package iih.en.comm.util;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

public class CollectionUtilsTest {

	public static void main(String[] args) throws BizException {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<21;i++){
			list.add(String.valueOf(i));
		}
		int step = 10;
		int current =0;
		while(current<list.size()){
			String[] nItems = EnCollectionUtils.subArray(list.toArray(new String[0]), current, step);
			if(nItems==null){
				break;
			}
			current+=nItems.length;
		}

	}

}
