package ex2;

import java.util.Comparator;

public class AlbumComparator implements Comparator<Album> {

	@Override
	public int compare(Album arg0, Album arg1) {
		// TODO Auto-generated method stub
		if (arg0.getNume().compareTo(arg1.getNume()) != 0) {
			return arg0.getNume().compareTo(arg1.getNume());
		}
		else {
			return arg0.getRating() - arg1.getRating();
		}
	}

}
