package com.harshit.auctionservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	 private List<Integer> l;
	    private Queue<Integer> q;


	    public ViewController() {
	        l=new ArrayList<Integer>() ;
	        for(int i=2;i<=187;i++)l.add(i);
	        Collections.shuffle(l);
	        q = new LinkedList<Integer>();

	    }

	    @RequestMapping(value = "/go", method = RequestMethod.GET)
	    public  String go(ModelMap model) {
	        l.get(0);
	        Integer last=l.remove(0);
	        q.add(last);
	        if(q.size()==6){
	            q.remove();
	        }
	        model.put("now", Integer.toString(last) );
	        String print=q.toString();
	        model.put("last5", print.substring(1,print.length()-1));

	        return "dash";
	    }


}
