package com.xvitcoder.angualrspringapp.service;

import java.util.List;

import com.xvitcoder.angualrspringapp.beans.Action;


public interface ActionService {
	
    public List<Action> getAllActions();

    public Action getActionById(Long id);

    public void addAction(Action action);

    public void deleteActionById(Long id);

    public void deleteAll();

    public void updateAction(Action action);
}
