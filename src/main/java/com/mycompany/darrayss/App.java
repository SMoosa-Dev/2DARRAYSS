package com.mycompany.darrayss;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Arrays for the days and bouquet types
        String[] days = {
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY",
            "SUNDAY"
        };

        String[] bouquets = {
            "ROSES",
            "TULIPS",
            "LILIES"
        };

        // 2D array:
        // Rows = 7 days
        // Columns = 3 bouquet types
        int[][] sales = new int[7][3];

        Scanner input = new Scanner(System.in);

        // ==========================================
        // ENTER SALES DATA
        // ==========================================

        System.out.println("==============================================");
        System.out.println("       FLOWER SHOP SALES INPUT");
        System.out.println("==============================================");

        // Outer loop goes through each day
        for (int i = 0; i < sales.length; i++) {

            System.out.println("\nEnter sales for " + days[i] + ":");

            // Inner loop goes through each bouquet type
            for (int j = 0; j < sales[i].length; j++) {

                System.out.print("  " + bouquets[j] + ": ");
                sales[i][j] = input.nextInt();
            }
        }

        // ==========================================
        // PRINT REPORT
        // ==========================================

        System.out.println("\n\n==============================================");
        System.out.println("       FLOWER SHOP WEEKLY SALES REPORT");
        System.out.println("==============================================");

        // Table headings
        System.out.printf("%-12s%10s%10s%10s%10s%n",
                "DAY", "ROSES", "TULIPS", "LILIES", "TOTAL");

        System.out.println("------------------------------------------------------------");

        // Array to store total sales for each day
        int[] dailyTotals = new int[7];

        // Array to store total sales for each bouquet type
        int[] bouquetTotals = new int[3];

        // Variable for total sales for the whole week
        int overallTotal = 0;

        // ==========================================
        // PRINT DAILY SALES AND CALCULATE TOTALS
        // ==========================================

        // Outer loop = days
        for (int i = 0; i < sales.length; i++) {

            int dailyTotal = 0;

            // Inner loop = bouquet types
            for (int j = 0; j < sales[i].length; j++) {

                // Add sales to the current day's total
                dailyTotal += sales[i][j];

                // Add sales to the bouquet's total
                bouquetTotals[j] += sales[i][j];

                // Add sales to the overall total
                overallTotal += sales[i][j];
            }

            // Store the day's total
            dailyTotals[i] = dailyTotal;

            // Print the day's information
            System.out.printf("%-12s%10d%10d%10d%10d%n",
                    days[i],
                    sales[i][0],
                    sales[i][1],
                    sales[i][2],
                    dailyTotal);
        }

        System.out.println("------------------------------------------------------------");

        // ==========================================
        // PRINT BOUQUET TOTALS
        // ==========================================

        System.out.printf("%-12s%10d%10d%10d%10d%n",
                "TOTAL",
                bouquetTotals[0],
                bouquetTotals[1],
                bouquetTotals[2],
                overallTotal);

        System.out.println();

        // ==========================================
        // TOTAL SALES FOR EACH BOUQUET
        // ==========================================

        System.out.println("TOTAL SALES FOR EACH BOUQUET:");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < bouquets.length; i++) {

            System.out.println("Total sales for " + bouquets[i]
                    + ": " + bouquetTotals[i]);
        }

        // ==========================================
        // TOTAL SALES FOR EACH DAY
        // ==========================================

        System.out.println("\nTOTAL SALES FOR EACH DAY:");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < days.length; i++) {

            System.out.println("Total sales for " + days[i]
                    + ": " + dailyTotals[i]);
        }

        // ==========================================
        // OVERALL TOTAL
        // ==========================================

        System.out.println("\n==============================================");
        System.out.println("OVERALL TOTAL SALES FOR THE WEEK: R "
                + overallTotal);
        System.out.println("==============================================");

        input.close();
    }
}