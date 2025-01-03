package iih.bl.inc.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.i.IBlincissCudService;
import iih.bl.inc.blinciss.i.IBlincissRService;
import iih.bl.inc.blinctf.d.BlIncTfDO;
import iih.bl.inc.blinctf.i.IBlinctfCudService;
import iih.bl.inc.dto.blinctf.d.BlIncIssDTO;
import iih.bl.inc.dto.blinctf.d.BlIncTfCondDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 发票票据转移
 * 
 * @author houll
 *
 */
public class IncTransferBP {
	
	public void exec(BlIncTfCondDTO cond) throws BizException {

		// 1、基础校验
		this.validate(cond);

		// 2、参数提取
		BlIncIssDTO param = getTransfParam(cond);

		// 3、实例化新增的记录
		BlIncIssDO newIncIss = initNewIncIss(param, cond);

		// 4、编辑的记录
		getUpdateIncIss(param, cond);

		
		// 5.新增票据转移记录
		this.saveTf(cond,newIncIss);

	}
	
	private void validate(BlIncTfCondDTO cond) throws BizException{
		if (cond == null){
			throw new BizException("提示:票据转移入参为空");
		}
		if (cond.getInclist() == null || cond.getInclist().size() <= 0){
			throw new BizException("提示:票据转移待转移票据为空");
		}
		if (StringUtils.isBlank(cond.getId_emp_iss_tf()) && StringUtils.isBlank(cond.getId_pc_tf())){
			throw new BizException("提示:票据转移接受人或计算机不能都为空");
		}
		if (!StringUtils.isBlank(cond.getId_emp_iss_tf()) && !StringUtils.isBlank(cond.getId_pc_tf())){
			throw new BizException("提示:票据转移接受人或计算机不能同时不为空");
		}
	}

	/**
	 * 获取转移的记录
	 * 
	 * @param 
	 * @return
	 */
	private BlIncIssDTO getTransfParam(BlIncTfCondDTO cond) {
		if (cond == null)
			return null;
		if (cond.getInclist() == null || cond.getInclist().size() < 1)
			return null;
		return (BlIncIssDTO) cond.getInclist().get(0);
	}

	/**
	 * 实例化新增的数据
	 * 
	 * @param param
	 * @param cond
	 * @return
	 * @throws BizException 
	 */
	private BlIncIssDO initNewIncIss(BlIncIssDTO param, BlIncTfCondDTO cond) throws BizException {
		BlIncIssDO rtn = new BlIncIssDO();
		BlIncIssDO olddo = ServiceFinder.find(IBlincissRService.class).findById(param.getId_inc_iss());
		rtn.setId_incca(param.getId_incca());
		rtn.setId_emp_iss(cond.getId_emp_iss_tf());// 领用人员为转移接受人员
		rtn.setId_pc(cond.getId_pc_tf());// 个人计算机
		rtn.setId_grp(Context.get().getGroupId());
		rtn.setId_org(Context.get().getOrgId());
		rtn.setCode_incpkg(param.getCode_incpkg());// 票据包编号
		// 新增的记录继承原有记录的可使用张数
		rtn.setInccn_use(olddo.getInccn_use());
		rtn.setInccn(olddo.getInccn());
		rtn.setIncno_cur(olddo.getIncno_cur());
		rtn.setDt_iss(new FDateTime());
		rtn.setNum_e(param.getNum_e());
		rtn.setNum_b(param.getNum_b());
		rtn.setFg_active(FBoolean.TRUE);
		//rtn.setFg_curuse(FBoolean.TRUE);
		rtn.setStatus(DOStatus.NEW);
		DAFacade daf =new DAFacade();
		daf.insertDO(rtn);
		return rtn;
	}

	/**
	 * 获取需要修改的数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private void getUpdateIncIss(BlIncIssDTO param, BlIncTfCondDTO cond) throws BizException {
		BlIncIssDO rtn = ServiceFinder.find(IBlincissRService.class).findById(param.getId_inc_iss());
		rtn.setFg_curuse(FBoolean.FALSE);
		rtn.setFg_active(FBoolean.FALSE);
		rtn.setStatus(DOStatus.UPDATED);
		// 原有记录更新 转移张数 = 可使用张数
		rtn.setInccn_trans(param.getInccn_use());
		//rtn.setCode_incpkg(param.getCode_incpkg());
		rtn.setNum_e(param.getNum_e());
		rtn.setNum_b(param.getNum_b());
		DAFacade daf =new DAFacade();
		daf.updateDO(rtn);
	}

	/**
	 * 新增票据转移记录信息
	 * 
	 * @param cond
	 * @param tfList
	 * @throws BizException
	 */
	private void saveTf(BlIncTfCondDTO cond,BlIncIssDO newIncIss) throws BizException {
		List<BlIncTfDO> blIncIssDOlist = new ArrayList<BlIncTfDO>();
		FArrayList tfList = cond.getInclist();
		for (Object obj : tfList) {
			BlIncIssDTO dto = (BlIncIssDTO) obj;
			if (!StringUtils.isBlank(dto.getId_incca())) {
				BlIncTfDO incDO = new BlIncTfDO();
				incDO.setId_incca(dto.getId_incca());
				incDO.setId_inc_iss(dto.getId_inc_iss());
				incDO.setId_inc_iss_tf(newIncIss.getId_inciss());
				incDO.setId_emp_iss(cond.getId_emp_iss());//票据领用人员
				incDO.setId_emp_iss_tf(cond.getId_emp_iss_tf());// 票据转移接受人员ID
				incDO.setId_pc(cond.getId_pc_tf());// 票据转移接受计算机
				incDO.setId_org(Context.get().getOrgId());
				incDO.setId_grp(Context.get().getGroupId());
				incDO.setCode_incpkg(dto.getCode_incpkg());// 票据包编号
				incDO.setStatus(DOStatus.NEW);
				blIncIssDOlist.add(incDO);
			}
		}
		if (blIncIssDOlist != null && blIncIssDOlist.size() > 0) {
			DAFacade daf =new DAFacade();
			daf.insertDOList(blIncIssDOlist);
		}
	}
}
