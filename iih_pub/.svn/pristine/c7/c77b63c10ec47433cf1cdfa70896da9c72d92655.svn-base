package iih.nmr.pkuf.i;

import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.nmr.pkuf.dto.wksnmr.d.WksNmrTreeDTO;
import iih.nmr.pkuf.healthedu.d.Healthedu1AggDO;
import iih.nmr.pkuf.nmrcoll.d.NmrCollDO;
import xap.mw.core.data.BizException;

public interface INmrPkufMaintanceService {

	/**
	 * 插入数据
	 * 
	 * @param Id_ent
	 * @param Id_set
	 * @throws BizException
	 */
	public NmrCollDO[] saveNrmCollRcdDO(String[] Id_ent, String[] Id_set) throws BizException;

	/**
	 * 交换两个医疗记录数据集的顺序
	 * 
	 * @param id_mrset_from
	 * @param id_mrset_to
	 * @throws BizException
	 */
	public NmrCollDO[] exchangedSortno(String id_mrset_from, String id_mrset_to) throws BizException;

	/**
	 * 删除文书记录
	 * 
	 * @param id_mrset
	 * @throws BizException
	 */
	public String deleteNmrCollRcd(String id_nmr_doc_coll) throws BizException;

	/**
	 * 护士站新增文书信息
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract WksNmrTreeDTO[] saveWksNmr(Ent4BannerDTO entInfo, WksNmrTreeDTO[] params) throws BizException;
	
	/**
	 * 住院患者健康教育评价单 tang.ws
	 * 
	 * @param aggdo
	 * @param 医疗记录自定义分类编码f
	 * @param 医疗记录类型编码
	 * @return
	 * @throws BizException
	 */
	public abstract Healthedu1AggDO saveEvaluation(Healthedu1AggDO aggdo) throws BizException;
}
