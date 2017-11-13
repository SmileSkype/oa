package cn.edu.action;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	public static final String LISTACTION = "listAction";
	public static final String ADDUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public String listAction = LISTACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	public String action2action = ACTION2ACTION;

}
