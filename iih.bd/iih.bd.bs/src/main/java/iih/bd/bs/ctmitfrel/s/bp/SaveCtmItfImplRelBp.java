package iih.bd.bs.ctmitfrel.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bs.ctmitf.d.CtmImplDO;
import iih.bd.bs.ctmitf.i.ICtmimplCudService;
import iih.bd.bs.ctmitfrel.d.CtmItfRelDO;
import iih.bd.bs.ctmitfrel.i.ICtmitfrelCudService;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存客开接口与实现类关系
 * 
 * @author hao_wu 2019-6-18
 *
 */
public class SaveCtmItfImplRelBp {

	public CtmItfRelDO[] exec(CtmItfRelDO[] ctmItfRelDOs) throws BizException {
		if (ArrayUtils.isEmpty(ctmItfRelDOs)) {
			return null;
		}

		// 1.保存客开接口实现类
		saveCtmImpl(ctmItfRelDOs);

		// 2.保存客开接口与实现类关系
		CtmItfRelDO[] result = saveRels(ctmItfRelDOs);

		return result;
	}

	private void saveCtmImpl(CtmItfRelDO[] ctmItfRelDOs) throws BizException {
		ArrayList<CtmImplDO> implDoList = new ArrayList<CtmImplDO>();
		HashMap<CtmImplDO, CtmItfRelDO> implMap = new HashMap<CtmImplDO, CtmItfRelDO>();
		for (CtmItfRelDO ctmItfRelDO : ctmItfRelDOs) {
			if (StringUtils.isBlank(ctmItfRelDO.getId_ctmimpl())) {
				CtmImplDO ctmImplDO = new CtmImplDO();
				ctmImplDO.setId_grp(Context.get().getGroupId());
				ctmImplDO.setId_org(Context.get().getOrgId());
				ctmImplDO.setCode(ctmItfRelDO.getCode_impl());
				ctmImplDO.setName(ctmItfRelDO.getName_impl());
				ctmImplDO.setEu_impltype(ctmItfRelDO.getEu_impltype());
				ctmImplDO.setDllname(ctmItfRelDO.getDllname_impl());
				ctmImplDO.setClsname(ctmItfRelDO.getClassname_impl());
				ctmImplDO.setPycode(CnToPy.getPyFirstCode(ctmImplDO.getName(), 8));
				ctmImplDO.setWbcode(CnToWB.getWBCode(ctmImplDO.getName(), 8));
				ctmImplDO.setMnecode(ctmImplDO.getCode());
				ctmImplDO.setNote(ctmItfRelDO.getNote_impl());
				ctmImplDO.setFg_sys(FBoolean.FALSE);
				ctmImplDO.setStatus(DOStatus.NEW);
				implDoList.add(ctmImplDO);
				implMap.put(ctmImplDO, ctmItfRelDO);
			}
		}

		if (implDoList.size() <= 0) {
			return;
		}

		ICtmimplCudService ctmimplCudService = ServiceFinder.find(ICtmimplCudService.class);
		CtmImplDO[] result = ctmimplCudService.insert(implDoList.toArray(new CtmImplDO[0]));

		for (int i = 0; i < result.length; i++) {
			CtmImplDO oldImplDo = implDoList.get(i);
			CtmItfRelDO ctmItfRelDO = implMap.get(oldImplDo);
			ctmItfRelDO.setId_ctmimpl(result[i].getId_ctmimpl());
			if (ctmItfRelDO.getStatus() == DOStatus.UNCHANGED) {
				ctmItfRelDO.setStatus(DOStatus.UPDATED);
			}
		}
	}

	private CtmItfRelDO[] saveRels(CtmItfRelDO[] ctmItfRelDOs) throws BizException {
		ICtmitfrelCudService ctmitfrelCudService = ServiceFinder.find(ICtmitfrelCudService.class);
		CtmItfRelDO[] result = ctmitfrelCudService.save(ctmItfRelDOs);
		return result;
	}
}
