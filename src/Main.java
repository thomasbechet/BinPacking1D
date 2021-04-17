import lpsolve.LpSolve;
import lpsolve.LpSolveException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        try {
            // Create a problem with 4 variables and 0 constraints
            LpSolve solver = LpSolve.makeLp(0, 4);

            // add constraints
            solver.strAddConstraint("3 2 2 1", LpSolve.LE, 4);
            solver.strAddConstraint("0 4 3 1", LpSolve.GE, 3);

            // set objective function
            solver.strSetObjFn("2 3 -2 3");

            // solve the problem
            solver.solve();

            // print solution
            System.out.println("Value of objective function: " + solver.getObjective());
            double[] var = solver.getPtrVariables();
            for (int i = 0; i < var.length; i++) {
                System.out.println("Value of var[" + i + "] = " + var[i]);
            }

            // delete the problem and free memory
            solver.deleteLp();
        }
        catch (LpSolveException e) {
            e.printStackTrace();
        }

//        try {
//            DataSet dataSet = new DataSet("binpack1d_02.txt");
//
//            // Solution solution = SolutionBuilder.firstFitSorted(dataSet);
//            // Solution solution = SolutionBuilder.oneItemPerBin(dataSet);
//            Solution solution = SolutionBuilder.firstFit(dataSet);
//
//            System.out.println("Bin capacity: " + dataSet.getBinCapacity());
//            System.out.println("Item count: " + dataSet.getItems().size());
//            System.out.println("Lower Bound: " + dataSet.getLowerBound());
//            System.out.println("Upper Bound: " + dataSet.getUpperBound());
//            System.out.println("Fitness: " + solution.fitness());
//            System.out.println("Bin count: " + solution.getBins().size());
//            /*int binIndex = 1;
//            for (Bin bin : solution.getBins()) {
//                System.out.print("(" + binIndex + ") ");
//                for (Item item : bin.getItems()) {
//                    System.out.print(item.getValue() + " ");
//                }
//                System.out.println();
//                binIndex++;
//            }*/
//
//            Random rng = new Random(12345);
//
//            int iteration = 100;
//            int neighbourCount = 100;
//            Solution bestSolution = solution;
//            for (int i = 0; i < iteration; i++) {
//                List<Solution> neighbours = bestSolution.generateNeighbours(neighbourCount, rng);
//                for (Solution neighbour : neighbours) {
//                    if (neighbour.fitness() < bestSolution.fitness()) {
//                        bestSolution = neighbour;
//                    }
//                }
//            }
//            System.out.println("New Fitness: " + bestSolution.fitness());
//            System.out.println("New Bin count: " + solution.getBins().size());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}