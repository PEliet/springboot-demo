package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping//增加方法,不用给前端返回数据，只需要返回一个成功的结果就行
    public Result save(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    @PutMapping//修改方法,同上
    public Result update(@RequestBody User user){
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Long id){
        return Result.success(userService.getById(id));
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public Result list(){
        return Result.success(userService.list());
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        userService.removeById(id);
        return Result.success();
    }

    /**
     * 用户分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String name){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();//先创建queryWrapper对象
        if(!"".equals(name)){
            queryWrapper.like(User::getName, name);//使用Like方法查询，查询数据库中包含上面name的整个字段
        }

        return Result.success(
                userService.page(new Page<>(pageNum, pageSize),queryWrapper)
        );
    }
}
/**
 * 对于service里还有什么方法，可去mybatis-plus官网查阅
 */



    