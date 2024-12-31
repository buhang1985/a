package iih.bd.srv.diagcate.s.bp;

import java.util.LinkedList;
import java.util.List;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.i.IDiagcateMDORService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDOCudService;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新疾病诊断定义DiagDefDO
 * 的上报标识fg_ur字段
 * @author guoyang
 *
 */
public class UpdateDiagDefBp {
	
	//疾病诊断分类
	private DiagCateDO[] diagCateDOArr;
	//诊断定义
	private DiagDefDO[] diagDefDOArr;
	//是否是删除逻辑
	private boolean isdelete;

	public UpdateDiagDefBp(boolean isdelete) {
		this.diagCateDOArr = null;
		this.diagDefDOArr = null;
		this.isdelete = isdelete;
	}

	public void exec(DiCateItemDO[] diCateItemDOs) throws BizException {
		//对于删除后规则或者被更新后规则执行完后即返回
		if(this.isdelete){
			UpdateDiagDefForDelete(diCateItemDOs);
			return;
		}
		//查询疾病诊断分类和疾病诊断定义
		QueryDiCateAndDiagDef(diCateItemDOs);
		
		LoopDiCateItemDO(diCateItemDOs);
		
		UpdateDiagDef();
	}
	
	/**
	 * 疾病诊断项目被删除或者
	 * 疾病诊断项目的诊断被改变
	 * 都更新诊断定义的上报标识fg_ur为false
	 * @param diCateItemDOs 
	 * @throws BizException 
	 */
	private void UpdateDiagDefForDelete(DiCateItemDO[] diCateItemDOs) throws BizException {
		
		if(diCateItemDOs == null || diCateItemDOs.length <= 0){
			return;
		}
		
		List<String> diagDefDOs = new LinkedList<String>();//诊断定义id集合
		
		for (DiCateItemDO diCateItemDO : diCateItemDOs) {
			diagDefDOs.add(diCateItemDO.getId_didef());
		}
		
		findDiagDefDOByIds(diagDefDOs);
		
		for (DiagDefDO diagDefDO : diagDefDOArr) {
			diagDefDO.setFg_ur(FBoolean.FALSE);
			diagDefDO.setStatus(DOStatus.UPDATED);
		}
		
		UpdateDiagDef();
	}

	/**
	 * 查询疾病诊断分类项目中所对应的疾病诊断分类和诊断定义
	 * DiCateItemDO对应的DiagCateDO和DiagDefDO
	 * @param diCateItemDOs
	 * @throws BizException 
	 */
	private void QueryDiCateAndDiagDef(DiCateItemDO[] diCateItemDOs) throws BizException {
		if(diCateItemDOs == null || diCateItemDOs.length <= 0){
			return;
		}
		
		List<String> diagDefDOs = new LinkedList<String>();//诊断定义id集合
		List<String> diagCateDOs = new LinkedList<String>();//疾病诊断分类id集合
		
		for (DiCateItemDO diCateItemDO : diCateItemDOs) {
			diagDefDOs.add(diCateItemDO.getId_didef());
			diagCateDOs.add(diCateItemDO.getId_dica());
		}
		
		findDiagDefDOByIds(diagDefDOs);
		
		findDiagCateDOByIds(diagCateDOs);
	}

	/**
	 * 查询疾病诊断分类DiagCateDO
	 * @param diagCateDOs
	 * @throws BizException 
	 */
	private void findDiagCateDOByIds(List<String> diagCateDOs) throws BizException {
		if (diagCateDOs == null || diagCateDOs.size() <= 0) {
			return;
		}
		IDiagcateMDORService diagcateMDORService = ServiceFinder.find(IDiagcateMDORService.class);
		diagCateDOArr = diagcateMDORService.findByIds(diagCateDOs.toArray(new String[]{}), FBoolean.FALSE);
	}

	/**
	 * 查询诊断定义DiagDefDO
	 * @param diagDefDOs 
	 * @throws BizException 
	 */
	private void findDiagDefDOByIds(List<String> diagDefDOs) throws BizException {
		if (diagDefDOs == null || diagDefDOs.size() <= 0) {
			return;
		}
		IDiagdefMDORService diagdefMDORService = ServiceFinder.find(IDiagdefMDORService.class);
		diagDefDOArr = diagdefMDORService.findByIds(diagDefDOs.toArray(new String[]{}), FBoolean.FALSE);
	}

	/**
	 * 遍历DiCateItemDO
	 * @param diCateItemDOs
	 */
	private void LoopDiCateItemDO(DiCateItemDO[] diCateItemDOs) {
		for (DiCateItemDO diCateItemDO : diCateItemDOs) {
			LoopDiagCateDO(diCateItemDO);
		}
	}
	
	/**
	 * 遍历DiagCateDO
	 * @param diCateItemDO
	 */
	private void LoopDiagCateDO(DiCateItemDO diCateItemDO) {
		if(diagCateDOArr == null || diagCateDOArr.length <= 0){
			return;
		}
		for (DiagCateDO diagCateDO : diagCateDOArr) {
			if (diCateItemDO.getId_dica().equals(diagCateDO.getId_dica())) {
				LoopDiagDefDO(diCateItemDO,diagCateDO);
				break;
			}
		}
	}

	/**
	 * 遍历DiagDefDO
	 * @param diCateItemDO
	 * @param diagCateDO
	 */
	private void LoopDiagDefDO(DiCateItemDO diCateItemDO, DiagCateDO diagCateDO) {
		if(diagDefDOArr == null || diagDefDOArr.length <= 0){
			return;
		}
		for (DiagDefDO diagDefDO : diagDefDOArr) {
			if (diCateItemDO.getId_didef().equals(diagDefDO.getId_didef())) {
				if (this.isdelete) {
					diagDefDO.setFg_ur(FBoolean.FALSE);
				}else{
					diagDefDO.setFg_ur(diagCateDO.getFg_ur());
				}
				diagDefDO.setStatus(DOStatus.UPDATED);
				break;
			}
		}
	}

	/**
	 * 更新诊断定义的上报标识fg_ur
	 * @throws BizException 
	 */
	private void UpdateDiagDef() throws BizException {
		if (diagDefDOArr == null || diagDefDOArr.length <= 0) {
			return;
		}
		IDiagdefMDOCudService diagdefMDOCudService = ServiceFinder.find(IDiagdefMDOCudService.class);
		diagdefMDOCudService.update(diagDefDOArr);
	}
}
