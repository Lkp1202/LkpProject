package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 修改完毕，再次提交
 * @小袁
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("find")
    public String find(Model model){
        List<User> list = userService.find();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "addUser";
    }

    @RequestMapping("add")
    public String addUser(String username,String password){
        userService.addUser(username,password);
        return "redirect:find";
    }

    @RequestMapping("toupdate")
    public String toupdate(int id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("update")
    public String update(User user){
        userService.update(user);
        return "redirect:find";
    }

    @RequestMapping("delete")
    public String delete(int id){
        userService.delete(id);
        return "redirect:find";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
