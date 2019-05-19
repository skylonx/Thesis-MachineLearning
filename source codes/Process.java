/*********26th November,2017
 * Updated 3rd Dec,2017
 * 
 * @author Skylon
 * New Class Process ,which stores attributes of gene.
 * ONly three required, gene name, title, type
 * Search should be performed by gene name.
 * 
 * 
 */

public class Process {
	

        private String geneName;
        private String tier;
        private String type;

        
        //constructor method;
        public Process(String geneName, String tier, String type) {
            this.geneName = geneName;
            this.tier = tier;
            this.type = type;
        }

        public String name() {
            return geneName;
        };

        public String tier() {
            return tier;
        }

        public String type() {
            return type;
        }

       // @Override
        public String toString() {
            return "Gene Symbol = " + geneName + ", Tier = " + tier
                    + ", Type = " + type + "]";
        }//end toString
    
}//end class body
