    package com.example.dungeoncrawlersgroup20;



    public class Leaderboard {
        private static Leaderboard instance;

        // Leaderboard data
        private int best1 = 0, best2 = 0, best3 = 0, best4 = 0, best5 = 0;
        private String string1 = "", string2 = "", string3 = "", string4 = "", string5 = "";

        private Leaderboard() {
        }

        public static synchronized Leaderboard getInstance() {
            if (instance == null) {
                instance = new Leaderboard();
            }
            return instance;
        }


        public void updateScores(int finalScore, String finalString) {
            if (finalScore > best5) {
                best5 = finalScore;
                string5 = finalString;
            }
            if (finalScore > best4) {
                int tmp = best4;
                String tmpS = string4;
                best4 = finalScore;
                string4 = finalString;
                best5 = tmp;
                string5 = tmpS;

            }
            if (finalScore > best3) {
                int tmp = best3;
                String tmpS = string3;
                best3 = finalScore;
                string3 = finalString;
                best4 = tmp;
                string4 = tmpS;

            }

            if (finalScore > best2) {
                int tmp = best2;
                String tmpS = string2;
                best2 = finalScore;
                string2 = finalString;
                best3 = tmp;
                string3 = tmpS;

            }

            if (finalScore > best1) {
                int tmp = best1;
                String tmpS = string1;
                best1 = finalScore;
                string1 = finalString;
                best2 = tmp;
                string2 = tmpS;

            }



        }


        //getters

        public int getBest1() {
            return best1;
        }
        public int getBest2() {
            return best2;
        }
        public int getBest3() {
            return best3;
        }
        public int getBest4() {
            return best4;
        }
        public int getBest5() {
            return best5;
        }
        public String getString1() {
            return string1;
        }
        public String getString2() {
            return string2;
        }
        public String getString3() {
            return string3;
        }
        public String getString4() {
            return string4;
        }
        public String getString5() {
            return string5;
        }



}