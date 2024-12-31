package iih.pi.reg.pat.s.rule;

import org.apache.commons.lang.StringUtils;

import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.s.bp.PiPatHandleAddressBP;
import iih.pi.utils.PiParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 新增患者时设置默认值规则
 * 
 * @author hao_wu
 *		   version ly 2019/01/17 设置出生日期(时分秒)默认值
 *
 * @param <T>
 */
public class SetPatDefaultValueWhenInsertRule<T> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... datas) throws BizException {
		if (datas == null || datas.length <= 0) {
			return;
		}

		for (T t : datas) {
			if (t instanceof PatiAggDO) {
				setDefaultValue((PatiAggDO[]) datas);
			} else if (t instanceof PatDO) {
				setDefaultValue((PatDO[]) datas);
			}
		}
	}

	private void setDefaultValue(PatDO[] datas) {
		// TODO Auto-generated method stub

	}

	private void setDefaultValue(PatiAggDO[] patAggs) throws BizException {
		SetPatAggDefaultValueBp bp = new SetPatAggDefaultValueBp();
		bp.exec(patAggs);

		setCode(patAggs);

		setChisCode(patAggs);

		setCreateEmp(patAggs);

		setPatAddr(patAggs);
		
		//设置出生日期(时分秒默认值)
		setDtBirthHms(patAggs);
		
		//设置id_person和fg_active
		setIdPersonFgactive(patAggs);
	}

	/**
	 * 设置id_person和fg_active
	 * @author zhang.hw
	 * @date 2019年10月12日
	 * @param patAggs
	 */
	private void setIdPersonFgactive(PatiAggDO[] patAggs) {
		for (PatiAggDO patiAggDO : patAggs) {
			PatDO patDO = patiAggDO.getParentDO();
			patDO.setId_person(patDO.getCode());
			patDO.setFg_active(FBoolean.TRUE);
		}
	}

	/**
	 * 生成的患者编码
	 * 
	 * @param patAggs
	 * @throws BizException
	 */
	private void setCode(PatiAggDO[] patAggs) throws BizException {
		for (PatiAggDO patiAggDO : patAggs) {
			setCode(patiAggDO);
		}
	}

	/**
	 * 设置CHIS码</br>
	 * 
	 * @param patAggs
	 * @throws BizException
	 */
	private void setChisCode(PatiAggDO[] patAggs) throws BizException {
		for (PatiAggDO patiAggDO : patAggs) {
			setChisCode(patiAggDO);
		}
	}

	/**
	 * 生成的患者编码
	 * 
	 * @param patiAggDO
	 * @throws BizException
	 */
	private void setCode(PatiAggDO patiAggDO) throws BizException {

		PatDO patDO = patiAggDO.getParentDO();
		if (StringUtils.isNotBlank(patDO.getCode()) && !"provide by chis".equals(patDO.getCode())) {
			return;
		}

		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		// 获取患者编码
		String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);

		patDO.setCode(code);
		patDO.setMnecode(code);
	}

	/**
	 * 设置CHIS码</br>
	 * 
	 * @param patiAggDO
	 * @throws BizException
	 */
	private void setChisCode(PatiAggDO patiAggDO) throws BizException {

		FBoolean createPatToChis = PiParamUtils.getCreatePatToChis();
		if (FBoolean.FALSE.equals(createPatToChis)) {
			if (StringUtils.isEmpty(patiAggDO.getParentDO().getBarcode_chis())) {
				patiAggDO.getParentDO().setBarcode_chis(patiAggDO.getParentDO().getCode());
			}
			return;
		}

		PatDO patdo = patiAggDO.getParentDO();

		if (StringUtils.isNotBlank(patdo.getBarcode_chis()) && !"provide by chis".equals(patdo.getBarcode_chis())) {
			return;
		}

		PiPatHpDO[] patHpDos = patiAggDO.getPiPatHpDO();
		String bjHpCode = this.getBjHpCode(patHpDos);
		if (StringUtils.isNotEmpty(bjHpCode)) {
			patdo.setBarcode_chis(bjHpCode.substring(0, 9));
		} else if (!StringUtil.isEmptyWithTrim(patdo.getCode())) {
			// 补充设置chis条码,规则为编码截取掉后两位
			String chisCode = patdo.getCode().length() > 2 ? patdo.getCode().substring(0, patdo.getCode().length() - 2)
					: patdo.getCode();

			patdo.setBarcode_chis(chisCode);
		}
	}

	/**
	 * 获取北京医保医保号
	 * 
	 * @param patHpDos
	 * @return
	 */
	private String getBjHpCode(PiPatHpDO[] patHpDos) {
		if (patHpDos == null || patHpDos.length <= 0) {
			return null;
		}

		for (PiPatHpDO piPatHpDO : patHpDos) {
			if (IPiPatConst.BJ_ID_HP.equals(piPatHpDO.getId_hp())) {
				return piPatHpDO.getNo_hp();
			}
		}
		return null;
	}

	/**
	 * 设置出生日期(时分秒)默认值
	 * @param patAggs
	 */
	private void setDtBirthHms(PatiAggDO[] patAggs) {
		
		for (PatiAggDO patiAggDO : patAggs) {
			PatDO patDO = patiAggDO.getParentDO();
			if(patDO.getDt_birth_hms() == null && patDO.getDt_birth() != null){
				patDO.setDt_birth_hms(new FDateTime(patDO.getDt_birth().getMillis()));
			}
		}
	}
	
	
	protected void setCreateEmp(PatiAggDO[] patAggs) {
		for (PatiAggDO patiAggDO : patAggs) {
			PatDO patDO = patiAggDO.getParentDO();
			patDO.setId_emp_create(Context.get().getStuffId());
		}
	}

	protected void setPatAddr(PatiAggDO[] patAggs) throws BizException {
		// 地址处理逻辑类
		PiPatHandleAddressBP addrBp = new PiPatHandleAddressBP();
		for (PatiAggDO patiAggDO : patAggs) {
			addrBp.exec(patiAggDO);
		}
	}
}
