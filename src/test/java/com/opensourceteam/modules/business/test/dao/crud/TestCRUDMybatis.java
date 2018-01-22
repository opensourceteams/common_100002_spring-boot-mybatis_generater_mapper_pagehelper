package com.opensourceteam.modules.business.test.dao.crud;

import com.opensourceteam.modules.business.test.dao.TTestMapper;
import com.opensourceteam.modules.business.test.po.TTest;
import com.opensourceteam.modules.configuration.spring.CustomMVCConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 开发人:刘文
 * 日期:  2018/1/22.
 * 功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes ={CustomMVCConfiguration.class} )
public class TestCRUDMybatis {
    Logger logger = LoggerFactory.getLogger(TestCRUDMybatis.class) ;

    @Autowired
    TTestMapper tTestMapper;
    /**
     * 插入一条数据
     */
    @Test
    public void insert(){
        TTest test = new TTest();
        String value = "11" ;
        test.setName("test_" + value);
        test.setRemark("中文remark_" + value);
        tTestMapper.insert(test);
    }

    /**
     * 更新一条数据(根据主键更新)
     */
    @Test
    public void update(){
        TTest test = new TTest();
        String value = "22" ;
        test.setId(2);
        test.setName("test_" + value);
        test.setRemark("中文remark_" + value);
        tTestMapper.updateByPrimaryKey(test);
    }

    /**
     * 删除一条数据(根据主键)
     */
    @Test
    public void deleteByPrimaryKey(){
        tTestMapper.deleteByPrimaryKey(2);
    }

    /**
     * 删除一条数据(根据对象的主键值值)
     */
    @Test
    public void delete(){
        TTest test = new TTest();
        test.setId(5);
        tTestMapper.delete(test);
    }

    @Test
    public void selectAll(){
        List<TTest> list = tTestMapper.selectAll();
        for(TTest po : list){
            logger.debug("po:{}",po);
        }
    }

}
