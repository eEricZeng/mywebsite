package site.zengguang.dialog.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.zengguang.dialog.service.IDialogService;

@Controller
@RequestMapping(value="/dialog")
public class DialogController {
    
    @Autowired
    private IDialogService dialogService;
    
    /**
     * 单个问答机器人回复.
     * 
     * @param map, key[
     *                  message: 用户提问信息]
     * @param request HttpServletRequest对象
     * @return
     */
    @RequestMapping(value="/bot/single", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendEmail(@RequestParam Map<String,Object> map,HttpServletRequest request){
        String sessionId = request.getSession().getId();
        return dialogService.getBotAnswer(map,sessionId);
    }
}
