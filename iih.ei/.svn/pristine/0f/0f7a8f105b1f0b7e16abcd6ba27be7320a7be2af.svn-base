package iih.ei.std.s.v1.bp.mp.basedata;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.ItemSrvInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.ItemSrvInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.SamptpInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.SamptpInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.basedata.qry.SamptpInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 
* @ClassName: GetSamptpInfoBp
* @Description: 获取标本类型数据
* @author zhy
* @date 2019年9月25日
*
 */
public class GetSamptpInfoBp extends IIHServiceBaseBP<BaseParamDTO, SamptpInfoResultDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(BaseParamDTO param) throws BizException {
		if (null == param.getPageinfo() || param.getPageinfo().size() < 1) {
			throw new BizException("未传入分页信息");
		}
	}

	/**
	 * 核心业务
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected SamptpInfoResultDTO process(BaseParamDTO param) throws BizException {
		SamptpInfoResultDTO resultDTO = new SamptpInfoResultDTO();
		SamptpInfoSql sql = new SamptpInfoSql();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<SamptpInfoDTO> findPagingData = findPagingData(pageInfoDto, sql.getQrySQLStr(), sql.getQryParameter(null), SamptpInfoDTO.class);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setSamptpinfo(ArrayListUtil.ConvertToFArrayList(findPagingData));
		return resultDTO;
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,SamptpInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}


}
