package com.han.helloconsumer.controller;

import com.han.helloconsumer.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
@Api(value = "SayController|一个用来测试swagger注解的控制器")
public class SwaggerController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @ResponseBody
    @RequestMapping(value = "/updatePassword",method= RequestMethod.GET)
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "int",example = "123"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String",example = "123"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String",example = "123")
    })
    // dataType使用包装类型失败，显示是引用类型
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword){
        if(userId <= 0 || userId > 2){
            return "未知的用户";
        }
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
            return "密码不能为空";
        }
        if(password.equals(newPassword)){
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }

    @ResponseBody
    @RequestMapping(value = "/updatePassword",method= RequestMethod.POST)
    @ApiOperation(value="修改用户密码-POST", notes="根据用户id修改密码")
    public String updatePasswordPost(@RequestBody User user){
        LOGGER.info(String.format("收到对象：%s",user.toString()));
        return "密码修改成功!";
    }

}
