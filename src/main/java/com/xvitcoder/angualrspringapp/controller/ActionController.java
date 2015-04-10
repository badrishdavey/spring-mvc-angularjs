package com.xvitcoder.angualrspringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xvitcoder.angualrspringapp.beans.Action;
import com.xvitcoder.angualrspringapp.service.ActionServiceImpl;

@Controller
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private ActionServiceImpl actionService;

    @RequestMapping("actionlist.json")
    public @ResponseBody List<Action> getActionList() {
        return actionService.getAllActions();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addAction(@RequestBody Action action) {
        actionService.addAction(action);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody void updateRailwayStation(@RequestBody Action action) {
        actionService.updateAction(action);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeAction(@PathVariable("id") Long id) {
        actionService.deleteActionById(id);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllActions() {
        actionService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getActionPartialPage(ModelMap modelMap) {
        return "actions/layout";
    }
}
