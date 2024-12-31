package iih.ci.mr.s.bp.qry;

import iih.bd.srv.billtypedto.d.BillTypeDto;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 获取费用分类修改后数据并赋值给账单分类DTO。
 * 
 * @author Silence
 *
 */
public class MrFpBlTypeSql {
	public BillTypeDto[] setEventStatus(MrFpBlTypeDO[] mrdos, String eventtype)
			throws BizException {

		ArrayList<BillTypeDto> result = new ArrayList<BillTypeDto>();

		// 遍历费用类别DO赋值给账单分类
		for (MrFpBlTypeDO mrdo : mrdos) {
			BillTypeDto dto = new BillTypeDto();
			dto.setCode(mrdo.getCode());
			dto.setName(mrdo.getName());
			dto.setPy_code(mrdo.getPycode());

			// 判断事件状态并赋值给账单分类
			if (IEventType.TYPE_UPDATE_AFTER.equals(eventtype)) {
				dto.setState("update");
			} else if (IEventType.TYPE_INSERT_AFTER.equals(eventtype)) {

				dto.setState("insert");
			} else if (IEventType.TYPE_DELETE_AFTER.equals(eventtype)) {

				dto.setState("delete");
			} else {
				continue;
			}

			// 加入列表中
			result.add(dto);

		}

		return result.toArray(new BillTypeDto[0]);
	}
}
