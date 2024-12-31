package iih.ci.mrm.s.insidecommontree;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.i.IMrmtypeMDORService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoCudService;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ci.mrm.i.insidecommontree.IMrmInsideCommonTreeService;
import iih.ci.mrm.i.param.ICiMrMParamService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IMrmInsideCommonTreeService.class }, binding = Binding.JSONRPC)
public class IMrmInsideCommonTreeServiceImpl implements
		IMrmInsideCommonTreeService {

	/**
	 * 根据科室及就诊类型获取病案分类
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrmTypeDO[] getMrmTypeDOs(String id_dept, String code_entp)
			throws BizException {
		IMrmtypeMDORService service = ServiceFinder
				.find(IMrmtypeMDORService.class);
		MrmTypeDO[] mrmTypeDOs = service.find(MrmTypeDO.ID_DEP + " = '"
				+ id_dept + "'", MrmTypeDO.SORTNO, FBoolean.FALSE);
		if (mrmTypeDOs != null && mrmTypeDOs.length > 0) {
			return mrmTypeDOs;
		}

		mrmTypeDOs = service.find(MrmTypeDO.CODE_ENTP + " = '" + code_entp
				+ "'", MrmTypeDO.SORTNO, FBoolean.FALSE);
		if (mrmTypeDOs != null && mrmTypeDOs.length > 0) {
			return mrmTypeDOs;
		}

		return null;
	}

	/**
	 * 根据病案主键获取所有病案文件
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrmFileInfoDO[] getCiMrmFileInfoDOs(String id_amr)
			throws BizException {
		ICimrmfileinfoRService service = ServiceFinder
				.find(ICimrmfileinfoRService.class);
		return service.find(CiMrmFileInfoDO.ID_CI_AMR + " = '" + id_amr + "'",
				CiMrmFileInfoDO.SORTNO, FBoolean.FALSE);
	}

	/**
	 * 病历查看扫描文件
	 * 
	 * @param id_ent
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiMrmFileInfoDO[] getCiMrmFileInfoDOsForMr(String id_ent,
			String id_mr) throws BizException {
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return null;
		}

		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder
				.find(ICimrmfileinfoRService.class);

		return ciMrmFileInfoRService.find(
				"id_ci_amr = '" + aMrDOs[0].getId_enhr() + "' and id_bu_sy = '"
						+ id_mr + "'", "sortno", FBoolean.FALSE);

	}

	/**
	 * 调整顺序
	 * 
	 * @param ciMrmFileInfoDo1
	 * @param ciMrmFileInfoDo2
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean changeIndex(CiMrmFileInfoDO ciMrmFileInfoDo1,
			CiMrmFileInfoDO ciMrmFileInfoDo2) throws BizException {

		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);

		int indexOne = ciMrmFileInfoDo1.getSortno();
		ciMrmFileInfoDo1.setSortno(ciMrmFileInfoDo2.getSortno());
		ciMrmFileInfoDo2.setSortno(indexOne);
		ciMrmFileInfoDo1.setStatus(DOStatus.UPDATED);
		ciMrmFileInfoDo2.setStatus(DOStatus.UPDATED);

		cimrmfileinfoCudService.save(new CiMrmFileInfoDO[] { ciMrmFileInfoDo1,
				ciMrmFileInfoDo2 });
		return null;
	}

	/**
	 * 重命名
	 * 
	 * @param id_amr
	 * @param id_bd_mrm_tp
	 * @param prefix
	 * @param hacNum
	 * @param numLength
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean rename(String id_amr, String id_bd_mrm_tp, String prefix,
			Boolean hacNum, int numLength) throws BizException {
		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder
				.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);
		String sqlWhere = " " + CiMrmFileInfoDO.ID_CI_AMR + " = '" + id_amr
				+ "' ";
		if (id_bd_mrm_tp != null && id_bd_mrm_tp != "") {
			sqlWhere += " and ";
		}

		return null;
	}

	/**
	 * 根据病案号重新整理文件名称
	 * 
	 * @param id_amr
	 * @param code_amr
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean sequenceArrange(String id_amr, String code_amr)
			throws BizException {

		ICiMrMParamService ciMrMParamService = ServiceFinder
				.find(ICiMrMParamService.class);

		String filePrefix = ciMrMParamService.getSysParamFilePrefix(Context
				.get().getOrgId());
		String numLength = ciMrMParamService.getSysParamNumLength(Context.get()
				.getOrgId());

		if (filePrefix.equals("CODE")) {
			filePrefix = code_amr;
		} else if (filePrefix == "NONE") {
			filePrefix = "";
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat(filePrefix);
			filePrefix = new FDateTime().toString(TimeZone.getDefault(),
					formatter);
		}

		if (filePrefix.equals("") && numLength.equals("-1")) {
			return false;
		}

		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);

		String sql = "select ci_mrm_fi.* from ci_mrm_fi ci_mrm_fi left join bd_mrm_tp bd_mrm_tp on bd_mrm_tp.id_bd_mrm_tp = ci_mrm_fi.id_bd_mrm_tp where ci_mrm_fi.id_ci_amr = '"
				+ id_amr + "' order by bd_mrm_tp.sortno,ci_mrm_fi.sortno";

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiMrmFileInfoDO> lsFI = (List<CiMrmFileInfoDO>) daf.execQuery(sql,
				new BeanListHandler(CiMrmFileInfoDO.class));

		for (int i = 0; i < lsFI.size(); i++) {
			if (numLength.equals("-1")) {
				lsFI.get(i).setName(filePrefix);
			} else if (numLength.equals("1")) {
				lsFI.get(i).setName(filePrefix + (i+1));
			} else {
				lsFI.get(i).setName(
						filePrefix
								+ padRight(String.valueOf(i+1),
										Integer.valueOf(numLength).intValue(),
										'0'));
			}
			lsFI.get(i).setStatus(DOStatus.UPDATED);
		}

		cimrmfileinfoCudService.save(lsFI.toArray(new CiMrmFileInfoDO[0]));
		
		return null;
	}

	/**
	 * 左补齐
	 * 
	 * @param src
	 * @param len
	 * @param ch
	 * @return
	 */
	private String padRight(String src, int len, char ch) {
		int diff = len - src.length();
		if (diff <= 0) {
			return src;
		}

		char[] charr = new char[len];
		System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
		for (int i = 0; i < diff; i++) {
			charr[i] = ch;
		}
		return new String(charr);
	}

}
