package cn.tedu.store.service.impl;

import cn.tedu.store.entity.QuestionType;
import cn.tedu.store.mapper.QuestionTypeMapper;
import cn.tedu.store.service.IQuestionTypeService;
import cn.tedu.store.service.ex.QuestionTypeDuplicateException;
import cn.tedu.store.service.ex.QuestionTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionTypeServiceImpl implements IQuestionTypeService {
    @Autowired
    QuestionTypeMapper questionTypeMapper;

    @Override
    public void addToQueType(String queType) {
        QuestionType questionType = new QuestionType();
        QuestionType check = null;
        questionType.setTitle(queType);
        LocalDateTime now = LocalDateTime.now();
        questionType.setGmtModified(now);
        questionType.setGmtCreate(now);
        check = questionTypeMapper.findByTitle(queType);
        if(check != null){
            throw new QuestionTypeDuplicateException("已有该类型");
        }
        Integer result = questionTypeMapper.insert(questionType);
        if (result != 1) {
            throw new QuestionTypeDuplicateException("服务器忙请稍后重试");
        }
    }

    @Override
    public QuestionType getTypeById(Integer id) {
        QuestionType result = questionTypeMapper.findById(id);
        if(result == null){
            throw new QuestionTypeNotFoundException("未找到此种类");
        }
        return result;
    }

    @Override
    public List<QuestionType> getAllTypes() {
        List<QuestionType> allTypes = questionTypeMapper.findAllTypes();
        return allTypes;
    }

    @Override
    public QuestionType getTypeByTitle(String title) {
        QuestionType byTitle = questionTypeMapper.findByTitle(title);
        if (byTitle == null){
            throw new QuestionTypeNotFoundException("未找到此类型");
        }
        return byTitle;
    }
}
