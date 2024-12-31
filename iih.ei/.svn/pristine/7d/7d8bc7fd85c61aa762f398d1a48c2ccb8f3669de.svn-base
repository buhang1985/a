package iih.ei.std.s.v1.bp.mp.basedata;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.ItemSrvInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.ItemSrvInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.basedata.qry.ItemObsInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 
* @ClassName: GetItemObsInfoBp
* @Description:获取检查申请项目数据
* @author zhy
* @date 2019年9月24日
*
 */
public class GetItemObsInfoBp extends IIHServiceBaseBP<BaseParamDTO, ItemSrvInfoResultDTO> {
	
	/**
	 * 入参校验
	 * @param param
	 * @throws BizException
	 */
	@Override
	protected void checkParam(BaseParamDTO param) throws BizException {
		if (null == param.getPageinfo() || param.getPageinfo().size() < 1) {
			throw new BizException("未传入分页信息");
		}
	}

	/**
	 * 核心业务
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected ItemSrvInfoResultDTO process(BaseParamDTO param) throws BizException {
		ItemSrvInfoResultDTO resultDTO = new ItemSrvInfoResultDTO();
		ItemObsInfoSql sql = new ItemObsInfoSql();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<ItemSrvInfoDTO> findPagingData = findPagingData(pageInfoDto, sql.getQrySQLStr(), sql.getQryParameter(null), ItemSrvInfoDTO.class);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setItemsrvinfo(ArrayListUtil.ConvertToFArrayList(findPagingData));
		return resultDTO;
	}

	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,ItemSrvInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}

}
