package cn.edu.action;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.edu.domain.Department;
import cn.edu.service.DepartmentService;
import cn.edu.utils.DeleteModel;
@SuppressWarnings("all")
public class DepartmentAction extends BaseAction implements ModelDriven<Department> {
	private Department model = new Department();
	public Department getModel() {
		return model;
	}
	private DepartmentService departmentService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	
	public String getAllDepartment() throws Exception {
		Collection<Department> departmentList = departmentService.getAllDepartment();
		/**
		 * 值栈
		 * 		值栈的生命周期
		 * 			值栈的声明周期就是一次请求
		 * 		值栈的数据结构
		 * 			对象栈和map栈
		 * 		对象栈和map的区别
		 * 			对象栈是一个list,map栈是一个map
		 * 		怎样把一个数据放入到map栈中
		 * 		怎样把一个数据放入到对象栈中
		 * 		对象栈中的数据有什么样的特殊之处
		 */
		//将departmentList放入对象栈的栈顶
//		ActionContext.getContext().getValueStack().push(departmentList);
//		//将departmentList放入对象栈的栈顶
//		ActionContext.getContext().getValueStack().getRoot().add(0, departmentList);
//		//将departmentList放入对象栈的栈底
//		ActionContext.getContext().getValueStack().getRoot().add(departmentList);
//		//获取对象栈的栈顶的元素
//		ActionContext.getContext().getValueStack().peek();
//		//移除对象栈的栈顶的元素
//		ActionContext.getContext().getValueStack().pop();
//		ActionContext.getContext().getValueStack().getRoot().remove(0);
//		//把一个map放入到map栈的栈顶
//		ActionContext.getContext().getValueStack().set("departmentList", departmentList);
		/**
		 * 对象栈的说明
		 * 	处于对象栈的对象中的属性是可以直接访问的
		 * 	如果对象栈中有一样名称的属性，从栈顶开始查找，找到为止
		 * 	一般情况下，回显数据应该放在对象栈中，这样效果比较高
		 * 	用ognl表达式访问对象栈，直接属性名称就可以了，不用加#
		 */
		//map栈
		/**
		 * 说明：
		 * 	request,session,application都在map栈中
		 * 	可以把一个对象放入map中
		 * 	ognl表达式访问map栈中的内容
		 * 		如果一个对象存在request中
		 * 			#request.对象的key值.属性
		 *		如果一个对象直接存放到map中
		 *			#对象的key值.属性
		 *		把一个对象放到map栈中，是不能直接访问该对象的属性
		 	如果对象放在map中，只能通过#...获取，放在对象栈中的数据可以通过不写或者top可以直接获取
		 */
		//把一个对象存放到map中
//		ActionContext.getContext().put("departmentList", departmentList);
		//#request.departmentList
		ServletActionContext.getRequest().setAttribute("departmentList", departmentList);
		
		/**
		 * list里面嵌套list
		 */
//		List<List<Department>> lists = new ArrayList<List<Department>>();
//		Department d1 = new Department();
//		d1.setDname("d1_name");
//		Department d2 = new Department();
//		d2.setDname("d2_name");
//		List<Department> list1 = new ArrayList<Department>();
//		list1.add(d1);
//		List<Department> list2 = new ArrayList<Department>();
//		list2.add(d2);
//		lists.add(list1);
//		lists.add(list2);
		
//		List<Map<String, Department>> lists = new ArrayList<Map<String,Department>>();
//		Map<String,Department> map1 = new HashMap<String, Department>();
//		Map<String,Department> map2 = new HashMap<String, Department>();
//		map1.put("d1", d1);
//		map2.put("d2", d2);
//		lists.add(map1);
//		lists.add(map2);
//		ActionContext.getContext().getValueStack().push(lists);
		
//		Map<String, List<Department>> maps = new HashMap<String, List<Department>>();
//		maps.put("list1",list1);
//		maps.put("list2", list2);
//		ActionContext.getContext().put("maps", maps);
		return listAction;
	}
	
	
	public String deleteDepartmentById() throws Exception {
		departmentService.deleteDepartmentById(model.getDid(), DeleteModel.DEL_PRE_RELEASE);
		return action2action;
	}
	
}
