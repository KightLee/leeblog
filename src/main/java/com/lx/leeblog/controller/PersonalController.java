package com.lx.leeblog.controller;

import com.lx.leeblog.pojo.Blog;
import com.lx.leeblog.pojo.User;
import com.lx.leeblog.service.BlogService;
import com.lx.leeblog.service.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by @author lixing on 2020/2/22 21:11
 */
@Controller
@RequestMapping("/person")
public class PersonalController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ClientUser clientUser;

    @GetMapping("/space")
    public String space(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Blog> blogs = blogService.selectBlogByUserId(user.getId());
        int focunum = blogService.selectUserFocuon(user.getId());
        int befocunum = blogService.selectUserBeFocuon(user.getId());
        User user1 = clientUser.selectUserByUserId(user.getId());
        model.addAttribute("blogs",blogs);
        model.addAttribute("user",user1);
        model.addAttribute("focunum",focunum);
        model.addAttribute("befocunum",befocunum);
        return "myspace";
    }

    /**
     * 与session取id不同， 这个controller使用点击的关注用户id进行查询
     * @param fid
     * @param model
     * @return
     */
    @GetMapping("/spacefocu")
    public String spacefocu(Long fid, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Blog> blogs = blogService.selectBlogByUserId(fid);
        int focunum = blogService.selectUserFocuon(fid);
        int befocunum = blogService.selectUserBeFocuon(fid);
        User user1 = clientUser.selectUserByUserId(fid);
        List<User> users = clientUser.selectUserFocuon(user.getId());
        model.addAttribute("blogs",blogs);
        model.addAttribute("user",user1);
        model.addAttribute("users",users);
        model.addAttribute("focunum",focunum);
        model.addAttribute("befocunum",befocunum);
        return "myspace";
    }

    /**
     * 跳转关注用户页
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/myfocu")
    public String myfocu(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<User> users = clientUser.selectUserFocuon(user.getId());
        User user1 = (User) session.getAttribute("user");
        List<Blog> blogs = blogService.selectBlogByUserId(user1.getId());
        int focunum = blogService.selectUserFocuon(user1.getId());
        int befocunum = blogService.selectUserBeFocuon(user1.getId());
        User user2 = clientUser.selectUserByUserId(user1.getId());
        model.addAttribute("blogs",blogs);
        model.addAttribute("user",user2);
        model.addAttribute("focunum",focunum);
        model.addAttribute("befocunum",befocunum);
        model.addAttribute("users", users);
        return "myfocu";
    }
}
