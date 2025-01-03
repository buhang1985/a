package iih.ci.mrfp.pub.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;
import iih.ci.mrfp.cimrfp.d.CiMrFpDO;
import iih.ci.mrfp.cimrfp.i.ICimrfpRService;
import iih.ci.mrfp.cimrfpquickfinddo.d.CiMrFpQuickFindDO;
import iih.ci.mrfp.cimrfpquickfinddo.i.ICimrfpquickfinddoCudService;
import iih.ci.mrfp.cimrfpquickfinddo.i.ICimrfpquickfinddoRService;
import iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import iih.ci.mrfp.di2mrfp.d.CiMrfpZydiDO;
import iih.ci.mrfp.di2mrfp.i.ICiMrFpXydiDORService;
import iih.ci.mrfp.di2mrfp.i.ICiMrfpZydiDORService;
import iih.ci.mrfp.di2mrfp.i.IDi2mrfpMDORService;
import iih.ci.mrfp.hospitalfirstpagedto.d.HospitalFirstPageDTO;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpMDORService;
import iih.ci.mrfp.othert2mrfp.d.CiMrFpOtherTDO;
import iih.ci.mrfp.othert2mrfp.i.IOthert2mrfpRService;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpRService;
import iih.ci.mrfp.pub.mrconst.IMrFpQuickFindConst;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import iih.ci.mrfp.sug2mrfp.i.ISug2mrfpRService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class AbstractCiMrFpQuickFindDOCompleteListener implements IBusinessListener {
	/**
	 * 病案首页快速查询DO
	 */
	private CiMrFpQuickFindDO mrFpQuickFindDO = new CiMrFpQuickFindDO();
	
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if (!((event.getSourceID().equals(IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE)
			|| event.getSourceID().equals(IMrEventConst.EVENT_SOURCE_MR_ZYFP_COMPLETE))
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER))) return;
		
		HospitalFirstPageDTO fpDOsNew = new HospitalFirstPageDTO();
		HospitalFirstPageDTO fpDOsOld = new HospitalFirstPageDTO();
		
		Object[] newObjs = ((BDCommonEvent)event).getNewObjs();
		Object[] oldObjs = ((BDCommonEvent)event).getOldObjs();
		
		if (newObjs != null && newObjs.length > 0) {
			fpDOsNew = (HospitalFirstPageDTO)newObjs[0];
		}
		if (oldObjs != null && oldObjs.length > 0) {
			fpDOsOld = (HospitalFirstPageDTO)oldObjs[0];
		}
		transferMrFpDataForQuickFind(fpDOsNew, fpDOsOld);
	}
	
	/**
	 * 病案首页相关数据至病案首页快速查询数据的转换方法
	 * @param fpDOsNew
	 * @param fpDOsOld
	 * @throws BizException
	 */
	private void transferMrFpDataForQuickFind(HospitalFirstPageDTO fpDOsNew, HospitalFirstPageDTO fpDOsOld) throws BizException {
		if (fpDOsNew == null)
			return;
		String id_ent = "";
		// 只取fpDOsNew，fpDOsOld为空
		CiMrFpPatDO[] fpDOs = (CiMrFpPatDO[])fpDOsNew.getLs_patient().get(0);
		
		if (fpDOs == null || fpDOs.length <= 0)
			return;
		
		id_ent = fpDOs[0].getId_ent();
		
		if (id_ent == null || "".equals(id_ent))
			return;
		
		CiMrFpDO[] ciMrFpDOs = new CiMrFpDO[]{};
		CiMrFpPatDO[] ciMrFpPatDOs = new CiMrFpPatDO[]{};
		CiMrFpOtherDO[] ciMrFpOtherDOs = new CiMrFpOtherDO[]{};
		CiMrFpOtherTDO[] ciMrFpOtherTDOs = new CiMrFpOtherTDO[]{};
		CiMrFpBlDO[] ciMrFpBlDOs = new CiMrFpBlDO[]{};
		CiMrFpSugDO[] ciMrFpSugDOs = new CiMrFpSugDO[]{};
		CiMrfpDiDO[] ciMrFpDiDOs = new CiMrfpDiDO[]{};
		CiMrFpXydiDO[] ciMrFpXydiDOs = new CiMrFpXydiDO[]{};
		CiMrfpZydiDO[] ciMrFpZydiDOs = new CiMrfpZydiDO[]{};
		// 定义服务
		ICimrfpRService fpService = ServiceFinder.find(ICimrfpRService.class);
		IPat2mrfpRService fpPatService = ServiceFinder.find(IPat2mrfpRService.class);
		IOther2mrfpMDORService fpOtherService = ServiceFinder.find(IOther2mrfpMDORService.class);
		IOthert2mrfpRService fpOtherTService = ServiceFinder.find(IOthert2mrfpRService.class);
		IBl2mrfpRService fpBlService = ServiceFinder.find(IBl2mrfpRService.class);
		ISug2mrfpRService fpSugService = ServiceFinder.find(ISug2mrfpRService.class);
		IDi2mrfpMDORService fpDiService = ServiceFinder.find(IDi2mrfpMDORService.class);
		ICiMrFpXydiDORService fpXydiService = ServiceFinder.find(ICiMrFpXydiDORService.class);
		ICiMrfpZydiDORService fpZydiService = ServiceFinder.find(ICiMrfpZydiDORService.class);
		
		ICimrfpquickfinddoRService fpQfRService = ServiceFinder.find(ICimrfpquickfinddoRService.class);
		ICimrfpquickfinddoCudService fpQfCudService = ServiceFinder.find(ICimrfpquickfinddoCudService.class);
		// 查询病案首页各表数据
		ciMrFpDOs = fpService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		ciMrFpPatDOs = fpPatService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		ciMrFpOtherDOs = fpOtherService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		ciMrFpOtherTDOs = fpOtherTService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		ciMrFpBlDOs = fpBlService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		ciMrFpSugDOs = fpSugService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		ciMrFpDiDOs = fpDiService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		
		if (ciMrFpDiDOs != null && ciMrFpDiDOs.length > 0) {
			String id_mrfpdi = ciMrFpDiDOs[0].getId_mrfpdi();
			// 根据病案首页主表主键分别查询西医诊断和中医诊断，查询结果主诊断放在第一位
			ciMrFpXydiDOs = fpXydiService.find(" id_mrfpdi = '" + id_mrfpdi + "' ", " id_mrfpdi, fg_maindi desc ", FBoolean.FALSE);
			ciMrFpZydiDOs = fpZydiService.find(" id_mrfpdi = '" + id_mrfpdi + "' ", " id_mrfpdi, fg_maindi desc ", FBoolean.FALSE);
		}
		// 获取病案首页各表字段名称的数组
		String[] mrFpArr = IMrFpQuickFindConst.MRFP_COL_MR_FP;
		String[] mrFpPatArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_PAT;
		String[] mrFpOtherArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_OTHER;
		String[] mrFpOtherTArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_OTHER_T;
		String[] mrFpBlArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_BL;
		String[] mrFpSugArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_SUG;
		String[] mrFpDiArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_DI;
		String[] mrFpXyDiArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_XYDI;
		String[] mrFpZyDiArr = IMrFpQuickFindConst.MRFP_COL_MR_FP_ZYDI;
		
		CiMrFpQuickFindDO[] dataDOs = fpQfRService.find(" col0006 = '" + id_ent + "' ", "", FBoolean.FALSE);
		
		if (dataDOs != null && dataDOs.length > 0) {
			mrFpQuickFindDO = dataDOs[0];
		}
		
		if (ciMrFpDOs != null && ciMrFpDOs.length > 0)
			// 病案首页主表数据的循环赋值流程
			dataTransfer(mrFpArr, IMrFpQuickFindConst.MR_FP_START_NUM, IMrFpQuickFindConst.MR_FP_END_NUM, ciMrFpDOs[0]);
		if (ciMrFpPatDOs != null && ciMrFpPatDOs.length > 0)
			// 病案首页患者信息表数据的循环赋值流程
			dataTransfer(mrFpPatArr, IMrFpQuickFindConst.MR_FP_PAT_START_NUM, IMrFpQuickFindConst.MR_FP_PAT_END_NUM, ciMrFpPatDOs[0]);
		if (ciMrFpOtherDOs != null && ciMrFpOtherDOs.length > 0)
			// 病案首页其他信息表数据的循环赋值流程
			dataTransfer(mrFpOtherArr, IMrFpQuickFindConst.MR_FP_OTHER_START_NUM, IMrFpQuickFindConst.MR_FP_OTHER_END_NUM, ciMrFpOtherDOs[0]);
		if (ciMrFpOtherTDOs != null && ciMrFpOtherTDOs.length > 0)
			// 病案首页附页信息表数据的循环赋值流程
			dataTransfer(mrFpOtherTArr, IMrFpQuickFindConst.MR_FP_OTHER_T_START_NUM, IMrFpQuickFindConst.MR_FP_OTHER_T_END_NUM, ciMrFpOtherTDOs[0]);
		if (ciMrFpBlDOs != null && ciMrFpBlDOs.length > 0)
			// 病案首页费用信息表数据的循环赋值流程
			dataTransfer(mrFpBlArr, IMrFpQuickFindConst.MR_FP_BL_START_NUM, IMrFpQuickFindConst.MR_FP_BL_END_NUM, ciMrFpBlDOs[0]);
		if (ciMrFpDiDOs != null && ciMrFpDiDOs.length > 0)
			// 病案首页诊断信息主表数据的循环赋值流程
			dataTransfer(mrFpDiArr, IMrFpQuickFindConst.MR_FP_DI_START_NUM, IMrFpQuickFindConst.MR_FP_DI_END_NUM, ciMrFpDiDOs[0]);
		
		if (ciMrFpSugDOs != null && ciMrFpSugDOs.length > 0) {
			// 用于记录病案首页快速查询字段中 每组的起始数值
			int sugStartNum = IMrFpQuickFindConst.MR_FP_SUG_START_NUM;
			// 病案首页手术信息表数据的循环赋值流程
			for (int k = 0; k < ciMrFpSugDOs.length; k++) {
				sugStartNum = dataTransfer(mrFpSugArr, sugStartNum, IMrFpQuickFindConst.MR_FP_SUG_END_NUM, ciMrFpSugDOs[k]);
			}
		}
		if (ciMrFpXydiDOs != null && ciMrFpXydiDOs.length > 0) {
			// 用于记录病案首页快速查询字段中 每组的起始数值
			int xydiStartNum = IMrFpQuickFindConst.MR_FP_XYDI_START_NUM;
			// 病案首页西医诊断表数据的循环赋值流程
			for (int k = 0; k < ciMrFpXydiDOs.length; k++) {
				xydiStartNum = dataTransfer(mrFpXyDiArr, xydiStartNum, IMrFpQuickFindConst.MR_FP_XYDI_END_NUM, ciMrFpXydiDOs[k]);
			}
		}
		if (ciMrFpZydiDOs != null && ciMrFpZydiDOs.length > 0) {
			// 用于记录病案首页快速查询字段中 每组的起始数值
			int zydiStartNum = IMrFpQuickFindConst.MR_FP_ZYDI_START_NUM;
			// 病案首页中医诊断表数据的循环赋值流程
			for (int k = 0; k < ciMrFpZydiDOs.length; k++) {
				zydiStartNum = dataTransfer(mrFpZyDiArr, zydiStartNum, IMrFpQuickFindConst.MR_FP_ZYDI_END_NUM, ciMrFpZydiDOs[k]);
			}
		}
		
		// 执行病案首页快速查询数据保存
		if (mrFpQuickFindDO.getId_mrqffp() == null) {
			mrFpQuickFindDO.setStatus(DOStatus.NEW);
		} else {
			mrFpQuickFindDO.setStatus(DOStatus.UPDATED);
		}
		fpQfCudService.save(new CiMrFpQuickFindDO[]{ mrFpQuickFindDO });
	}
	
	/**
	 * 病案首页快速查询数据的循环赋值方法
	 * @param mrFpStrArr 所需的病案首页的字段名称数组
	 * @param startNum 病案首页快速查询的字段编号的起始数值
	 * @param endNum 病案首页快速查询的字段编号的结束数值
	 * @param fpDO 待赋值的DO数据
	 * @return 下一组数据的起始编号
	 */
	private int dataTransfer(String[] mrFpStrArr, int startNum, int endNum, BaseDO fpDO) {
		// 用于标记每一组数据的字段编号起点
		int resultNum = startNum;
		
		for (int i = 0; i < mrFpStrArr.length; i++) {
			// 用于判断病案首页数据是否已经set过一次
			int num = 0;
			
			for (int j = startNum; j <= endNum; j++) {
				if (i == num) {
					String colName = getQuickFindColName(j);
					// 格式化字段名称
					String mrFpStr = colNameFormat(mrFpStrArr[i]);
					// 取值与赋值
					Object attrVal = fpDO.getAttrVal(mrFpStr);
					mrFpQuickFindDO.setAttrVal(colName, attrVal);
					break;
				}
				num++;
			}
			// 对于手术或者诊断类型的数据，下一个DO赋值前，调整病案首页快速查询字段的循环开始数值，进入下一组数据的赋值流程
			if (i == mrFpStrArr.length - 1) {
				resultNum += mrFpStrArr.length;
			}
		}
		return resultNum;
	}
	
	/**
	 * 字段名称格式转换（首字母大写，其余字母小写）
	 * @param colName
	 * @return
	 */
	private String colNameFormat(String colName) {
		
		if (colName == null || "".equals(colName))
			return null;
		
		String resultStr = colName.toLowerCase();
		String firstLetter = resultStr.substring(0, 1).toUpperCase();
		String otherLetter = resultStr.substring(1, resultStr.length());
		
		return firstLetter + otherLetter;
	}
	
	/**
	 * 获取病案首页快速查询的字段名称
	 * @param number 字段编号
	 * @return
	 */
	private String getQuickFindColName(int number) {
		// 病案首页快速查询表中将要使用的字段名
		String colName = IMrFpQuickFindConst.COL_NAME;
		
		if (number < 10) {
			colName += "000" + number;
		} else if (number >= 10 && number < 100) {
			colName += "00" + number;
		} else if (number >= 100 && number < 1000) {
			colName += "0" + number;
		} else {
			colName += number;
		}
		return colName;
	}
	
}
