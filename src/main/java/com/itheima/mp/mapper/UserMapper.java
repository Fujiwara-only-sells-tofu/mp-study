package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    //必须要用@Param注解声明wrapper变量名称为ew
    void updateBalanceByIds(@Param("ew") LambdaUpdateWrapper<User> wrapper,@Param("amount") int amount);

    @Update("update user set balance=balance-#{money} where id= #{id}")
    void deductionBalance(Long id, Integer money);
}
