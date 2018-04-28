package com.swagger.controller;

import com.swagger.domain.Person;
import com.swagger.domain.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;


@RestController
@Api(value="api",description="测试接口描述")
public class TestController {

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "getPersonById/{id}", method = RequestMethod.GET)
    public Result getUserById (@PathVariable(value = "id") Integer id){
        System.out.println("=========接受参数ID" + id + "输出结果集");
        return Result.success(new Person(18,"whiney",0));
    }

    /**
     * 查询用户列表
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "getPersonList", method = RequestMethod.GET)
    public Result getUserList (){
        return Result.success(new ArrayList<Person>(){{
            add(new Person(15,"whiney0",0));
            add(new Person(16,"whiney1",0));
            add(new Person(17,"whiney2",0));
        }});
    }

    /**
     * 添加用户
     * @param person
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据Person对象创建用户")
    @ApiImplicitParam(name = "person", value = "实体Person", required = true, dataType = "Person")
    @RequestMapping(value = "addPerson", method = RequestMethod.POST)
    public Result addPerson (@RequestBody Person person){

        System.out.println("age = " + person.getAge() +
                " name = " + person.getName() +
                " sex = " + person.getSex());

        return Result.success();
    }

    /**
     * 忽略API
     */
    @ApiIgnore
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result  jsonTest() {
        return Result.success();
    }

}
