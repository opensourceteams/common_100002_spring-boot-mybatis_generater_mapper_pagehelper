package com.opensourceteam.modules.business.test.dao.crud;

import com.github.pagehelper.PageHelper;
import com.opensourceteam.modules.business.test.dao.TTestUuidMapper;
import com.opensourceteam.modules.business.test.po.TTestUuid;
import com.opensourceteam.modules.configuration.spring.CustomMVCConfiguration;
import org.apache.ibatis.session.RowBounds;
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
public class TestPageHelper {
    Logger logger = LoggerFactory.getLogger(TestPageHelper.class) ;

    @Autowired
    TTestUuidMapper mapper;

    /**
     * 排序后分页
     */
    @Test
    public void pageAndOrder(){
        /**
         * pageNum: 页数
         * pageSize: 每页的数量
         */
        PageHelper.startPage(3, 10);
        Condition condition = new Condition(TTestUuid.class);
        condition.setOrderByClause("age desc,name desc");
        List<TTestUuid> list = mapper.selectByExample(condition);
        for(TTestUuid po : list){
            logger.debug("po:{}",po);
        }
        System.out.println();
    }
    /**
     * 分页查询
     */
    @Test
    public void selectPageHelperStartPage(){
        /**
         * pageNum: 页数
         * pageSize: 每页的数量
         */
        PageHelper.startPage(2, 10);
        List<TTestUuid> list = mapper.select(null);
        for(TTestUuid po : list){
            logger.debug("po:{}",po);
        }
        System.out.println();
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPageHelperStartPage2(){
        for(int i = 0 ; i< 10 ;i ++){
            /**
             * pageNum: 页数 (页数从1开始)
             * pageSize: 每页的数量
             */
            PageHelper.startPage(i, 10);
            logger.debug("页数:{}",i);
            List<TTestUuid> list = mapper.select(null);

            for(TTestUuid po : list){
                logger.debug("po:{}",po);
            }
            System.out.println();
        }
    }


    /**
     * 分页查询
     */
    @Test
    public void selectRowBoundsMapper(){
        TTestUuid query = new TTestUuid();
        for( int i = 1; i <= 10 ; i++){
            logger.debug("页数:{}",i);
            /**
             * offset: 页数
             * limit: 每页的数量
             */
            RowBounds rowBounds = new RowBounds(i,10);
            List<TTestUuid> list = mapper.selectByRowBounds(query,rowBounds) ;
            for(TTestUuid po : list){
                logger.debug("po:{}",po);
            }
            System.out.println();
        }

    }

}
