package com.xvitcoder.angualrspringapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xvitcoder.angualrspringapp.beans.Action;


@Service("ActionService")
public class ActionServiceImpl implements ActionService {
    
    private static List<Action> acList = new ArrayList<Action>();
    private static Long id = 0L;

    public Action getActionById(Long id) {
    	
    	return findActionById(id);
    }

    private Action findActionById(Long id) {
        for (Action rs : acList) {
            if (rs.getId() == id) {
                return rs;
            }
        }

        return null;
    }

	public List<Action> getAllActions() {		
		return acList;
	}


	public void addAction(Action action) {
		action.setId(++ id);
		acList.add(action);		
		
	}

	public void deleteActionById(Long id) {
		Action found = findActionById(id);
        if (found != null) {
            acList.remove(found);
            id--;
        }
		
	}

	public void updateAction(Action action) {
		Action found = findActionById(action.getId());
        if (found != null) {
            acList.remove(found);
            acList.add(action);
        }
	}
	
    public void deleteAll() {
        acList.clear();
        id = 0L;
    }
}
