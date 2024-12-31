package iih.pi.reg.pat.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pathist.d.PiPatHistDO;
import iih.pi.reg.pathist.i.IPathistCudService;

/**
 * 患者关键信息变动记录类
 * 
 * @author ly
 *
 */
public class PiPatInsertHistoryBP {

	// 需要关注记录的属性:姓名,移动电话,患者分类
	private final String[] CONCERN_PROPERTY = new String[] { PatDO.CODE, PatDO.NAME, PatDO.ID_CODE, PatDO.DT_BIRTH,
			PatDO.MOB, PatDO.PATICATE_NAME, PatDO.FG_INVD };
	private final String[] CONCERN_PROPERTY_NAME = new String[] { "编码", "姓名", "证件号", "出生日期", "移动电话", "患者分类", "失效标志" };
	private final String[] SPECIAL_PROPERTY = new String[] { PatDO.PASSWORD };
	private final String[] SPECIAL_PROPERTY_NAME = new String[] { "密码" };

	private final String OLD = "原:";
	private final String NEW = "变更后:";

	/**
	 * 关键信息变动记录
	 * 
	 * @param oldPat
	 *            原患者DO
	 * @param newPat
	 *            新患者DO
	 * @param isCombine
	 *            是否为合并
	 * @throws BizException
	 */
	public void exec(PatDO oldPat, PatDO newPat, boolean isCombine) throws BizException {

		String content = "";

		if (isCombine) {
			content = this.handleCombine(oldPat, newPat);
		} else {
			content = this.handleUpdate(oldPat, newPat);
		}

		if ("".equals(content))
			return;

		// 登录变更记录
		this.insertHistory(newPat.getId_pat(), content);

	}

	/**
	 * 处理患者合并信息
	 * 
	 * @param oldPat
	 * @param newPat
	 * @throws BizException 
	 */
	private String handleCombine(PatDO oldPat, PatDO newPat) throws BizException {
		//根据旧数据查出跟他相关的数据
		IPatiMDORService  patirservice = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs = patirservice.findByAttrValString(PatDO.ID_PERSON, oldPat.getCode());
		StringBuffer content = new StringBuffer();
		content.append(oldPat.getName()+"[");
		for(PatDO patDO:patDOs){
			content.append(patDO.getCode()+"、");
		}
		content.deleteCharAt(content.length()-1);
		content.append("]被合并到" + newPat.getName() + "[" + newPat.getCode()	+ "]");
		return content.toString();
	}

	/**
	 * 处理患者变更信息
	 * 
	 * @param oldPat
	 * @param newPat
	 */
	private String handleUpdate(PatDO oldPat, PatDO newPat) {
		String content = "";
		for (int i = 0; i < CONCERN_PROPERTY.length; i++) {

			String prop = CONCERN_PROPERTY[i];
			String propName = CONCERN_PROPERTY_NAME[i];
			if (!this.equal(oldPat.getAttrVal(prop), newPat.getAttrVal(prop))) {

				content += propName + "," + OLD + this.getStringValue(oldPat.getAttrVal(prop)) + "," + NEW
						+ this.getStringValue(newPat.getAttrVal(prop)) + "  ";
			}
		}

		for (int i = 0; i < SPECIAL_PROPERTY.length; i++) {

			String prop = SPECIAL_PROPERTY[i];
			String propName = SPECIAL_PROPERTY_NAME[i];
			if (!this.equal(oldPat.getAttrVal(prop), newPat.getAttrVal(prop))) {

				content += propName + "被修改  ";
			}
		}

		return content;
	}

	/**
	 * 插入患者变更记录
	 * 
	 * @param patId
	 * @param content
	 */
	private void insertHistory(String patId, String content) throws BizException {

		IPathistCudService service = ServiceFinder.find(IPathistCudService.class);

		PiPatHistDO histDo = new PiPatHistDO();
		histDo.setId_grp(Context.get().getGroupId());
		histDo.setId_org(Context.get().getOrgId());
		histDo.setId_pat(patId);
		histDo.setDt_modify(new FDateTime());
		histDo.setEmp_modify(Context.get().getStuffId());
		histDo.setDes_modify(content);
		histDo.setStatus(DOStatus.NEW);

		service.insert(new PiPatHistDO[] { histDo });
	}

	/**
	 * 对比两个数据是否相同
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	private boolean equal(Object obj1, Object obj2) {

		if (obj1 == null && obj2 == null)
			return true;

		if (obj1 != null)
			return obj1.equals(obj2);

		return false;
	}

	/**
	 * 获取对象string值
	 * 
	 * @param obj
	 * @return
	 */
	private String getStringValue(Object obj) {

		if (obj == null)
			return "";

		return this.changeNY(obj.toString());
	}

	/**
	 * 转换NY
	 * 
	 * @param str
	 * @return
	 */
	private String changeNY(String str) {

		if ("Y".equals(str) || "y".equals(str))
			return "是";

		if ("N".equals(str) || "n".equals(str))
			return "否";

		return str;
	}
}
