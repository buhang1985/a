package iih.en.comm.rule;

import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.bizrule.IRule;

/**
 * 集团组织设定规则，默认从上下文中获取
 * @author yank
 *
 * @param <T>
 */
public class GrpOrgInitRule<T>  implements IRule<T> {
	private static final String FIELD_ID_GRP = "Id_grp";
	private static final String FIELD_ID_GROUP = "Id_group";
	private static final String FIELD_ID_ORG = "Id_org";	
	private String grpIdField;
	private String orgIdField;
	//默认构造函数
	public GrpOrgInitRule(){}
	/**
	 * 构造函数
	 * @param grpIdField 集团ID字段
	 * @param orgIdField 组织ID字段
	 */
	public GrpOrgInitRule(String grpIdField,String orgIdField){
		this.grpIdField = grpIdField;
		this.orgIdField = orgIdField;
	}
	/**
	 * 执行
	 * @param dos DO集合
	 */
	@Override
	public void process(T... dos) throws BizException {
		if (EnValidator.isEmpty(dos))
			return;
		if (dos[0] instanceof IBaseDO){
			this.loadGrpOrgField(((IBaseDO)dos[0]).getDODesc());			
			for(int i=0;i<dos.length;i++) {
				this.setGrpAndOrgVal((IBaseDO)dos[i]);
			}
		}
	}
	/**
	 * 设置集团组织的值
	 * @param baseDO DO对象
	 */
	private void setGrpAndOrgVal(IBaseDO baseDO) {
		if (!EnValidator.isEmpty(this.grpIdField))
			baseDO.setAttrVal(this.grpIdField, EnContextUtils.getGrpId());
		if (!EnValidator.isEmpty(this.orgIdField))
			baseDO.setAttrVal(this.orgIdField, EnContextUtils.getOrgId());
	}
	/**
	 * 加载集团、组织字段
	 * @param doDesc
	 */
	private void loadGrpOrgField(IDODesc doDesc) throws BizException{
		if(!EnValidator.isEmpty(this.grpIdField)){
			if(doDesc.getAttrDesc(this.grpIdField)==null){
				throw new BizException(String.format("实体%s集团字段%s不存在！",doDesc.getLabel(),this.grpIdField));
			}
		}		
		if(!EnValidator.isEmpty(this.grpIdField)){
			if(doDesc.getAttrDesc(this.grpIdField)==null){
				throw new BizException(String.format("实体%s组织字段%s不存在！",doDesc.getLabel(),this.orgIdField));
			}
		}
		//如果实现了基础档案接口
		Map<String,String> map = doDesc.getIBDDataInfoFldMap();
		if(map!=null){
			this.grpIdField  = map.get("id_group");
			this.orgIdField = map.get("id_org");	
		}
		//如果还为空，试图从已知的字段中加载
		if(EnValidator.isEmpty(this.grpIdField)){
			if(doDesc.getAttrDesc(FIELD_ID_GRP)!=null){
				this.grpIdField = FIELD_ID_GRP;
			}else if(doDesc.getAttrDesc(FIELD_ID_GROUP)!=null){
				this.grpIdField = FIELD_ID_GROUP;
			}
		}
		if(EnValidator.isEmpty(this.orgIdField)){
			if(doDesc.getAttrDesc(FIELD_ID_ORG)!=null){
				this.orgIdField = FIELD_ID_ORG;
			}
		}		
	}
}
