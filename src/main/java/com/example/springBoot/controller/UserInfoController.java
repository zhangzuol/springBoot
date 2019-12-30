package com.example.springBoot.controller;

import com.example.springBoot.domain.Employee;
import com.example.springBoot.mapper.test1.EmpMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    EmpMapper empMapper;
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(Model model,Integer pageNum){
        System.out.println("当前页为："+pageNum);
        pageNum = pageNum==null?1:pageNum;
        PageHelper.startPage(pageNum,2);
        List<Employee> list = empMapper.getAll();
        PageInfo<Employee> page = new PageInfo<>(list);
        System.out.println("总记录条数为："+page.getTotal());
        model.addAttribute("page",page);
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }

    /**
     * 上传业务
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/userInfo/uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("D:/" + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/userInfo/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
