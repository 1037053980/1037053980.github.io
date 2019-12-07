
// var video_ascii = false;
// var contron_ascii = true;

var contron_click = true;
// function start_end_ascii(){
//     if(contron_ascii){
//         document.getElementById("video_to_ascii").innerText="正常";
//         contron_ascii = false;
//         video_ascii = true;
//     }
//     else{
//         document.getElementById("video_to_ascii").innerText= "ascii视频";
//         camera.pause();
//         video_ascii = false;
//         contron_ascii = true;
//     }
// }

//输入房间号
function inrooms() {
    if(contron_click){
        var input_content = document.getElementById("roomName").value;
        if(input_content){
            var center=document.getElementById("center_in");
            center.style.opacity = "0";
            contron_click = false;
            document.getElementById("namepoint").innerText = "您的房间号："+input_content;
            roomwebrtc(input_content);
        }
        else{
            alert("房间号为空,请输入房间号");
        }

    }

}

//随机房间号
function randomroom() {
    // 产生随机数
    if(contron_click){
        contron_click = false;
        if (!location.hash) {
            location.hash = Math.floor(Math.random() * 0xFFFFFF).toString(16);
        }
        //隐藏输入信息
        var center=document.getElementById("center_in");
        center.style.opacity = "0";
        // 获取房间号
        var roomHash = location.hash.substring(1);
        document.getElementById("namepoint").innerText = "您的房间号："+roomHash;
        roomwebrtc(roomHash);

    }

}

function roomwebrtc(roomHash) {
    // 放置你自己的频道id, 这是我注册了ScaleDrone 官网后，创建的channel
// 你也可以自己创建
    var drone = new ScaleDrone('87fYv4ncOoa0Cjne');
// 房间名必须以 'observable-'开头
    var roomName = 'observable-' + roomHash;
    var configuration = {
        iceServers: [{
            urls: 'stun:stun.l.google.com:19302' // 使用谷歌的stun服务
        }]
    };
    var room;
    var pc;
    drone.on('open', function(error){
        if (error) { return console.error(error);}

        room = drone.subscribe(roomName);
        room.on('open', function(error){
            if (error) {onError(error);}
        });

        // 已经链接到房间后，就会收到一个 members 数组，代表房间里的成员
        // 这时候信令服务已经就绪
        room.on('members', function(members){
            console.log('MEMBERS', members);

            // 如果你是第二个链接到房间的人，就会创建offer
            var isOfferer = members.length === 2;
            startWebRTC(isOfferer);
        });
    });
    function onSuccess() {}

    function onError(error) {
        // console.error(error);
    }

// 通过Scaledrone发送信令消息
    function sendMessage(message) {
        drone.publish({
            room: roomName,
            message
        });
    }

    function startWebRTC(isOfferer) {
        pc = new RTCPeerConnection(configuration);

        // 当本地ICE Agent需要通过信号服务器发送信息到其他端时
        // 会触发icecandidate事件回调
        pc.onicecandidate = function(event){
            if (event.candidate) {
                sendMessage({ 'candidate': event.candidate });
            }
        };

        // 如果用户是第二个进入的人，就在negotiationneeded 事件后创建sdp
        if (isOfferer) {
            // onnegotiationneeded 在要求sesssion协商时发生
            pc.onnegotiationneeded = function() {
                // 创建本地sdp描述 SDP (Session Description Protocol) session描述协议
                pc.createOffer().then(localDescCreated).catch(onError);
            };
        }

        // 当远程数据流到达时，将数据流装载到video中
        pc.onaddstream = function(event){
            remoteVideo.srcObject = event.stream;
        };

        // 获取本地媒体流
        navigator.mediaDevices.getUserMedia({
            audio: true,
            video: true,
        }).then( function(stream) {
            // 将本地捕获的视频流装载到本地video中
                localVideo.srcObject = stream;
            // 将本地流加入RTCPeerConnection 实例中 发送到其他端
            pc.addStream(stream);
        }, onError);

        // 从Scaledrone监听信令数据
        room.on('data', function(message, client){
            // 消息是我自己发送的，则不处理
            if (client.id === drone.clientId) {
                return;
            }

            if (message.sdp) {
                // 设置远程sdp, 在offer 或者 answer后
                pc.setRemoteDescription(new RTCSessionDescription(message.sdp), function(){
                    // 当收到offer 后就接听
                    if (pc.remoteDescription.type === 'offer') {
                        pc.createAnswer().then(localDescCreated).catch(onError);
                    }
                }, onError);
            }
            else if (message.candidate) {
                // 增加新的 ICE canidatet 到本地的链接中
                pc.addIceCandidate(
                    new RTCIceCandidate(message.candidate), onSuccess, onError
                );
            }
        });
    }

    function localDescCreated(desc) {
        pc.setLocalDescription(desc, function(){
            sendMessage({ 'sdp': pc.localDescription });
        },onError);
    }
}


