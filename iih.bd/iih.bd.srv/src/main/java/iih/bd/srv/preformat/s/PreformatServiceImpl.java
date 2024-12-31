package iih.bd.srv.preformat.s;

import iih.bd.srv.preformat.i.IPreformatService;
import iih.bd.srv.preformat.s.bp.GetNewSerialNumberBp;

public class PreformatServiceImpl implements IPreformatService {

	@Override
	public int getNewSerialNumber(String str, boolean b) {
		GetNewSerialNumberBp bp = new GetNewSerialNumberBp();
		return bp.exec(str, b);
	}

}
