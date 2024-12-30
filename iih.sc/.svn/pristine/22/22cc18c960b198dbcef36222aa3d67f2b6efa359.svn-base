package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 生成ID操作
 * @author yankan
 *
 */
public class GenerateIdBP {
	private List<String> idList = new ArrayList<String>();
	private Integer amount;
	public GenerateIdBP(Integer amount){
		this.amount = amount;
	}
	/**
	 * 获取新的ID
	 * @return
	 */
	public String getNewId(){
		if(idList.size()==0){
			this.generateIds();
		}
		String id = this.idList.get(0);		
		idList.remove(0);//使用就移除
		return id;
	}
	/**
	 * 生成ID
	 */
	private void generateIds(){
		DBUtil dbUtil = new DBUtil();
		String[] ids = dbUtil.getOIDs(this.amount);
		idList.addAll(Arrays.asList(ids));
	}
}
