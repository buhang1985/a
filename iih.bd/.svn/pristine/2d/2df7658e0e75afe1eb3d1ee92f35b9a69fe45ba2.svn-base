package iih.bd.mhi.hptreatdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import iih.bd.mhi.hptreatdircomp.i.IHptreatdircompCudService;
import iih.bd.mhi.hptreatdircomp.s.bp.adapter.HpTreatDirCompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author dj.zhang
 *
 */
public class DelTreatCompBp {
		/**
		 * @Description: 执行删除逻辑
		 * @param hpId
		 * @param hpTreatDirCompDtOs
		 * @return
		 * @throws BizException
		 */
		public HpTreatDirCompDTO[] exec(String hpId, HpTreatDirCompDTO[] hpTreatDirCompDtOs) throws BizException {
			HpTreatDirCompDO[] hpTreatDirCompDos = ConvertDtoToDircompDOs(hpId, hpTreatDirCompDtOs);
			deleteHpTreatDirComp(hpTreatDirCompDos);
			String[] hpTreatIds = getHpTreatIds(hpTreatDirCompDtOs);
			HpTreatDirCompDTO[] findHpTreatCompByHpTreatId = findHpTreatCompByHpTreatId(hpId, hpTreatIds);
			return findHpTreatCompByHpTreatId;
		}

		/**
		 * @Title: findHpTreatCompByTreatId
		 * @Description: 通过医保系统ID,查找保存过的数据DO，进行回显
		 * @param hpId
		 * @param hpTreatIds
		 * @return
		 * @throws BizException
		 */
		private HpTreatDirCompDTO[] findHpTreatCompByHpTreatId(String hpId, String[] hpTreatIds) throws BizException {
			FindHpTreatCompByHpTreatIdBp bp = new FindHpTreatCompByHpTreatIdBp();
			HpTreatDirCompDTO[] hpTreatDirComps = bp.exec(hpId, hpTreatIds);
			return hpTreatDirComps;
		}

		/**
		 * @Title: getHpTreatIds
		 * @Description: 获取ID集合
		 * @param hpTreatDirCompDtOs
		 * @return
		 */
		private String[] getHpTreatIds(HpTreatDirCompDTO[] hpTreatDirCompDtOs) throws BizException {
			ArrayList<String> ids = new ArrayList<String>();

			for (HpTreatDirCompDTO dto : hpTreatDirCompDtOs) {
				ids.add(dto.getId_treat());
			}

			return ids.toArray(new String[0]);
		}

		/**
		 * @Title: deleteHpTreatDirComp
		 * @Description: 通过调用基础服务删除适配器处理生成的DO
		 * @param hpTreatDirCompDos
		 * @return HpTreatDirCompDO[]
		 * @throws BizException
		 */
		private void deleteHpTreatDirComp(HpTreatDirCompDO[] hpTreatDirCompDos) throws BizException {
			IHptreatdircompCudService treatdircompCudService = ServiceFinder.find(IHptreatdircompCudService.class);
			treatdircompCudService.save(hpTreatDirCompDos);

		}

		/**
		 * @Title: ConvertDtoToDircompDOs
		 * @Description: 通过适配器，把DTO中的数据转移到DO中
		 * @param hpId
		 * @param hpTreatDirCompDtOs
		 * @return HpTreatDirCompDO[]
		 * @throws BizException
		 */
		private HpTreatDirCompDO[] ConvertDtoToDircompDOs(String hpId, HpTreatDirCompDTO[] hpTreatDirCompDtOs)
				throws BizException {
			ArrayList<HpTreatDirCompDO> hpTreatDirCompDoList = new ArrayList<HpTreatDirCompDO>();
			HpTreatDirCompDOAdapter adapter = new HpTreatDirCompDOAdapter();

			for (HpTreatDirCompDTO compDTO : hpTreatDirCompDtOs) {
				HpTreatDirCompDO HpTreatDirCompDO = adapter.getTreatdircompDO(hpId, compDTO);
				HpTreatDirCompDO.setEu_status(DirCompState.NOT_COMP);
				HpTreatDirCompDO.setStatus(DOStatus.DELETED);
				hpTreatDirCompDoList.add(HpTreatDirCompDO);
			}
			return hpTreatDirCompDoList.toArray(new HpTreatDirCompDO[0]);
		}

	}


