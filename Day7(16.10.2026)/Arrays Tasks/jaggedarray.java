package Arrays;

public class jaggedarray {

	public static void main(String[] args) {

        int[][] marks = {
            {80, 90},
            {70, 85, 95},
            {60, 75, 80, 90}
        };
        
        for(int i=0;i<marks.length;i++) {
        	int total=0;
        	
        	for(int j=0;j<marks[i].length;j++) {
        		total+=marks[i][j];
        	}
        	
        	System.out.println("Student " + (i + 1) + " Total: " + total);
        }

	}

}
