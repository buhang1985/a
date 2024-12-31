package iih.bl.inc.ep;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.CpntpEnum;
import iih.bd.pp.bdcpnca.i.IBdcpncaMDORService;
import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.d.BlcpninAggDO;
import iih.bl.inc.blcpnin.i.IBlcpninCudService;
import iih.bl.inc.blcpnin.i.IBlcpninRService;
import iih.bl.inc.blcpntpdto.d.BlCpnTpDto;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 优惠券入库EP
 * @author li_pengying
 * @since 2017-06-30
 *
 */
public class CpnInEp {
	/**
	 * 获取优惠券入库所需的左侧树对应的数据集
	 * @return
	 * @throws BizException
	 */
	public BlCpnTpDto[] getBlCpnTpList() throws BizException{
		List<BlCpnTpDto> blCpnTpDtoList = new ArrayList<BlCpnTpDto>();
		//从枚举类中将所有元素的键值对取出来加入到集合中去，构成树的1级节点
		BlCpnTpDto blCpnTpCh = new BlCpnTpDto();
		blCpnTpCh.setId_tr(CpntpEnum.CASHCOUPON.toString());
		blCpnTpCh.setName_tr("现金券");
		blCpnTpCh.setLevel_tr(1);
		BlCpnTpDto blCpnTpDs = new BlCpnTpDto();
		blCpnTpDs.setId_tr(CpntpEnum.DISCOUNTCOUPON.toString());
		blCpnTpDs.setName_tr("折扣券");
		blCpnTpDs.setLevel_tr(1);
		BlCpnTpDto blCpnTpSp = new BlCpnTpDto();
		blCpnTpSp.setId_tr(CpntpEnum.SPECIALOFFERCOUPON.toString());
		blCpnTpSp.setName_tr("特价券");
		blCpnTpSp.setLevel_tr(1);
		BlCpnTpDto blCpnTpEp = new BlCpnTpDto();
		blCpnTpEp.setId_tr(CpntpEnum.EXPERIENCECOUPON.toString());
		blCpnTpEp.setName_tr("体验券");
		blCpnTpEp.setLevel_tr(1);
		BlCpnTpDto blCpnTpEc = new BlCpnTpDto();
		blCpnTpEc.setId_tr(CpntpEnum.EXCHANGECOUPON.toString());
		blCpnTpEc.setName_tr("换购券");
		blCpnTpEc.setLevel_tr(1);
		blCpnTpDtoList.add(blCpnTpCh);
		blCpnTpDtoList.add(blCpnTpDs);
		blCpnTpDtoList.add(blCpnTpSp);
		blCpnTpDtoList.add(blCpnTpEp);
		blCpnTpDtoList.add(blCpnTpEc);
		
		IBdcpncaMDORService service = ServiceFinder.find(IBdcpncaMDORService.class);
		//从优惠券分类中查询出所有 已经启用的单码优惠券
		BdCpncaDO[] bdCpncaList = service.find(" a0.Active_state = '2' and a0.fg_each = 'Y' ", null, FBoolean.FALSE);
		if(bdCpncaList != null && bdCpncaList.length > 0){
			for(BdCpncaDO bdCpncaDO : bdCpncaList){
				BlCpnTpDto blCpnTpDto = new BlCpnTpDto();
				blCpnTpDto.setId_tr(bdCpncaDO.getId_cpnca());
				blCpnTpDto.setName_tr(bdCpncaDO.getName());
				blCpnTpDto.setCode_tr(bdCpncaDO.getCode());
				blCpnTpDto.setCoderule_cpn(bdCpncaDO.getCoderule_cpn());
				blCpnTpDto.setId_parent(bdCpncaDO.getEu_cpntp().toString());  //以优惠券类型这个枚举类型的值来构成父子关系，同属于一种优惠券类型的优惠券分类节点挂在同一父节点下
				blCpnTpDto.setLevel_tr(2);
				blCpnTpDtoList.add(blCpnTpDto);
			}
		}
		return blCpnTpDtoList.toArray(new BlCpnTpDto[]{});
	}
	
	
	/**
	 * 当在入库单页签时 点击删除按钮事件，删除入库单 和入库里的所有优惠券 即删除整个AggDO
	 * @param blCpnInDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean deleteBlCpnInInfo(BlCpnInDO blCpnInDO) throws BizException{
		IBlcpninRService rservice = ServiceFinder.find(IBlcpninRService.class);
		IBlcpninCudService cservice = ServiceFinder.find(IBlcpninCudService.class);
		BlcpninAggDO blcpninAggDO = rservice.findById(blCpnInDO.getId_cpnin());
		if(blcpninAggDO == null){
			throw new BizException("此入库单不存在，请刷新界面！");
		}
		blcpninAggDO.getParentDO().setStatus(DOStatus.DELETED);
		cservice.save(new BlcpninAggDO[]{blcpninAggDO});
		
		return FBoolean.TRUE;
	}
}
