package jp.ac.asojuku.batch;

import java.io.File;
import java.util.Date;

public class BatchCSVFileDelete {
	final static long DAY_MILLISECONDS = (1000 * 60 * 60 * 24 );

	public static void main(String[] args) {

		if( args.length != 1 ){
			System.out.println("BatchCSVFileDelete:arg error["+args.length+"]");
			return;

		}

		try{
			System.out.println("BatchCSVFileDelete -start-");
			Date now = new Date();
			long nowTime = now.getTime();

			File dir = new File(args[0]);
		    File[] files = dir.listFiles();
		    for (int i = 0; i < files.length; i++) {
		        File file = files[i];

		        //ファイルじゃない場合は処理しない
		        if( !file.isFile() ){
		        	continue;
		        }

		        long dist = nowTime - file.lastModified();
		        if( dist >= DAY_MILLISECONDS){
		        	//1日以上たっていたら削除
		        	if( file.delete() ){
		        		System.out.println(file.getName()+" is deleted");
		        	}
		        }

		    }
			System.out.println("BatchCSVFileDelete -end-");
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
