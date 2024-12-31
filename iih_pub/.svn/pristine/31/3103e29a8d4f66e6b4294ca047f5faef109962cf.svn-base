package iih.bd.mm.meterial.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;

import java.util.Map;

import iih.bd.mm.meterial.d.MeterialAggDO;

/**
* 医疗物品基础信息，耗材目录，价表 合并保存
*/
public interface IMeterialExtCudService {
	/**
	 * 医疗物品基础信息，耗材目录，价表 合并保存
	 * @param aggdos 物品基本信息
	 * @param srvAggdo 物品服务基本信息
	 * @param medPriSrvDO 价表服务
	 * @param priSrvDOArr 价表
	 * @throws BizException
	 */
    public abstract MeterialAggDO saveMMInfoSrvPri(MeterialAggDO aggdos, MedSrvDO srvdo, PriSrvDO medPriSrvDO,
			SrvPriDO[] srvPriDOArr) throws BizException;
    
    /**
	*  医疗物品基础信息，耗材目录，价表 合并删除
	* @param idMMs 物品主键数组
	* @throws BizException 
	*/
    public abstract void delMMInfoSrvPri(String[] idMMs) throws BizException;
    /**
     * 根据idmm的主键 查询 物品服务，价表服务 和所有价格
     * @param id_mm
     * @return
     * @throws BizException
     */
    public Map getMcAllByMmID(String id_mm) throws BizException;
}
