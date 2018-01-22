package com.opensourceteam.modules.business.test.dao.crud;

import com.opensourceteam.modules.business.test.dao.TTestMapper;
import com.opensourceteam.modules.business.test.dao.TTestUuidMapper;
import com.opensourceteam.modules.business.test.po.TTest;
import com.opensourceteam.modules.business.test.po.TTestUuid;
import com.opensourceteam.modules.configuration.spring.CustomMVCConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * 开发人:刘文
 * 日期:  2018/1/22.
 * 功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes ={CustomMVCConfiguration.class} )
public class TestCRUDMybatisUUID {
    Logger logger = LoggerFactory.getLogger(TestCRUDMybatisUUID.class) ;

    @Autowired
    TTestUuidMapper mapper;


    /**
     * 插入一条数据
     */
    @Test
    public void insert(){
        TTestUuid test = new TTestUuid();
        String value = "89" ;
        test.setName("test_" + value);
        test.setAge(20);
        test.setRemark("中文remark_" + value);
        mapper.insert(test);
    }


    /**
     * 插入一条数据
     */
    @Test
    public void insertBatch(){
        for( int i = 0 ; i < 10 ; i++){
            TTestUuid test = new TTestUuid();
            String value = "" + i ;
            test.setName("test_" + value);
            test.setRemark("中文remark_" + value);
            test.setAge(20);
            mapper.insert(test);
        }

    }

    /**
     * 更新一条数据(根据主键更新)
     */
    @Test
    public void update(){
        TTestUuid test = new TTestUuid();
        String value = "3" ;
        test.setId("75a406d1fbec11e7af7b00fff3451ede");
        test.setName("test_" + value);
        test.setRemark("中文remark_" + value);
        mapper.updateByPrimaryKey(test);
    }

    /**
     * 删除一条数据(根据主键)
     */
    @Test
    public void deleteByPrimaryKey(){
        mapper.deleteByPrimaryKey("75a406d1fbec11e7af7b00fff3451ede");
    }

    /**
     * 删除一条数据(根据对象的主键值值)
     */
    @Test
    public void delete(){
        TTestUuid test = new TTestUuid();
        test.setId("42b1c49dfbec11e7af7b00fff3451ede");
        mapper.delete(test);
    }

    @Test
    public void selectAll(){
        List<TTestUuid> list = mapper.selectAll();
        for(TTestUuid po : list){
            logger.debug("po:{}",po);
        }
    }

    /**
     * 查询后排序
     */
    @Test
    public void orderBy(){

        Condition condition = new Condition(TTestUuid.class);
        condition.setOrderByClause("age desc,name desc");
        List<TTestUuid> list = mapper.selectByExample(condition);
        for(TTestUuid po : list){
            logger.debug("po:{}",po);
        }
        System.out.println();
    }

}
