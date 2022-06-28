import java.util.Objects;
import java.util.Scanner;
public class Assignment3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        Matrix[] mats = new Matrix[100];
        int count = 0;
        Functions functions = new Functions();
        Menu menu = new Menu();
        Check check = new Check();
        int tag = 0;
        label:
        while (tag == 0){
            menu.display();
            System.out.print("Enter Task: ");
            int choose = sc.nextInt();
            if(choose == 22){
                tag++;
            }
            else if(choose == 20){
                System.out.print("Enter the label of Matrices you wish to retrieve: ");
                String label = s.next();
                int val = 0;
                for(int i = 0; i < count; i++){
                    if(Objects.equals(mats[i].getLabel(), label)){
                        System.out.println(mats[i].getName() + " = ");
                        mats[i].display();
                        val++;
                    }
                }
                if (val == 0){
                    System.out.println("Matrix of this label does not exist!");
                }
            }
            else if(choose == 21){
                System.out.print("Enter the name of Matrices you wish to retrieve: ");
                String label = s.next();
                int val = 0;
                for(int i = 0; i < count; i++){
                    if(Objects.equals(mats[i].getName(), label)){
                        System.out.println(mats[i].getName() + " = ");
                        mats[i].display();
                        val++;
                    }
                }
                if (val == 0){
                    System.out.println("Matrix of this name does not exist!");
                }
            }
            else if(choose == 17){
                Matrix a = null;
                System.out.print("Enter the name of Matrix: ");
                String name = s.next();
                int val = 0;
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        var++;
                    }
                }
                if (var == 0){
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                for(int j = 0; j < count; j++){
                    if(Objects.equals(mats[j].getName(), name) && (mats[j].getCol() == mats[j].getRow())){
                        a = mats[j];
                        val++;
                    }
                }
                if (val == 0){
                    System.out.println("Enter a Square Matrix for this function!");
                    continue label;
                }
                Matrix result = functions.Sum_of_Transpose(a);
                result.display();
            }
            else if(choose == 1){
                System.out.print("Enter name of the Matrix you wish to create: ");
                String name = s.next();
                System.out.print("Enter number of rows: ");
                int r = sc.nextInt();
                System.out.print("Enter number of columns: ");
                int c = sc.nextInt();
                System.out.println("Enter the elements of the Matrix: ");
                float[][] mat = new float[r][c];
                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++){
                        mat[i][j] = sc.nextInt();
                    }
                }
                Matrix matrix = new Matrix(mat,r,c);
                System.out.println(name + " = ");
                matrix.display();
                if (check.NullMatrix(matrix)){
                    NullMatrix a = new NullMatrix(mat,r,c);
                    a.setName(name);
                    mats[count] = a;
                    count++;
                }
                if (check.OnesMatrix(matrix)){
                    Ones a = new Ones(mat,r,c);
                    a.setName(name);
                    mats[count] = a;
                    count++;
                    continue label;
                }
                 if (check.Row(matrix)){
                    Row a = new Row(mat,r,c);
                    a.setName(name);
                    mats[count] = a;
                    count++;
                    continue label;
                }
                if (check.Column(matrix)){
                    Column a = new Column(mat,r,c);
                    a.setName(name);
                    mats[count] = a;
                    count++;
                    continue label;
                }
                if (check.Rectangular(matrix)){
                    Rectangular a = new Rectangular(mat,r,c);
                    a.setName(name);
                    mats[count] = a;
                    count++;
                    continue label;
                }
                if (check.SquareMatrix(matrix)){
                    if (check.Singleton(matrix)){
                        Singleton a = new Singleton(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                        continue label;
                    }
                    else{
                        if (check.Identity(matrix)) {
                            Identity a = new Identity(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Scalar(matrix)) {
                            Scalar a = new Scalar(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Diagonal(matrix)){
                            Diagonal a = new Diagonal(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Symmetric(matrix)){
                            Symmetric a = new Symmetric(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Skew_Symmetric(matrix)){
                            Skew_Symmetric a = new Skew_Symmetric(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Singular(matrix)){
                            Singular a = new Singular(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Upper_Triangular(matrix)){
                            Upper_Triangular a = new Upper_Triangular(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        if (check.Lower_Triangular(matrix)){
                            Lower_Triangular a = new Lower_Triangular(mat, r, c);
                            a.setName(name);
                            mats[count] = a;
                            count++;
                            continue label;
                        }
                        Square a = new Square(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                }
            }
            else if (choose == 2){
                System.out.print("Enter the label of matrix you wish to create: ");
                String label = s.next();
                System.out.print("Enter name of the Matrix you wish to create: ");
                String name = s.next();
                System.out.print("Enter number of rows: ");
                int r = sc.nextInt();
                System.out.print("Enter number of columns: ");
                int c = sc.nextInt();
                System.out.println("Enter the elements of the Matrix: ");
                float[][] mat = new float[r][c];
                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++){
                        mat[i][j] = sc.nextInt();
                    }
                }
                Matrix matrix = new Matrix(mat,r,c);
                if (Objects.equals(label, "Square Matrix")){
                    if (check.SquareMatrix(matrix)){
                        Square a = new Square(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Singular Matrix")){
                    if (check.Singular(matrix)){
                        Singular a = new Singular(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Column Matrix")){
                    if (check.Column(matrix)){
                        Column a = new Column(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Row Matrix")){
                    if (check.Row(matrix)){
                        Row a = new Row(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, " Scalar Matrix")){
                    if (check.Scalar(matrix)){
                        Scalar a = new Scalar(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Diagonal Matrix")){
                    if (check.Diagonal(matrix)){
                        Diagonal a = new Diagonal(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Singleton Matrix")){
                    if (check.Singleton(matrix)){
                        Singleton a = new Singleton(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Ones Matrix")){
                    if (check.OnesMatrix(matrix)){
                        Ones a = new Ones(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Null Matrix")){
                    if (check.NullMatrix(matrix)){
                        NullMatrix a = new NullMatrix(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Upper Triangular Matrix")){
                    if (check.Upper_Triangular(matrix)){
                        Upper_Triangular a = new Upper_Triangular(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Lower Triangular Matrix")){
                    if (check.Lower_Triangular(matrix)){
                        Lower_Triangular a = new Lower_Triangular(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Identity Matrix")){
                    if (check.Identity(matrix)){
                        Identity a = new Identity(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Rectangular Matrix")){
                    if (check.Rectangular(matrix)){
                        Rectangular a = new Rectangular(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                        continue label;
                    }
                }
                else if (Objects.equals(label, "Symmetric Matrix")){
                    if (check.Symmetric(matrix)){
                        Symmetric a = new Symmetric(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                    }
                }
                else if (Objects.equals(label, "Skew Symmetric Matrix")){
                    if (check.Skew_Symmetric(matrix)){
                        Skew_Symmetric a = new Skew_Symmetric(mat,r,c);
                        a.setName(name);
                        mats[count] = a;
                        count++;
                    }
                    else{
                        System.out.println("This Matrix is not of the form of it's label!");
                    }
                }
                else{
                    System.out.println("Please enter a valid label!");
                }
            }
            else if (choose == 3){
                Matrix a = null;
                System.out.print("Enter the name of the Matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                a.display();
                System.out.println("1. Change One Element\n" + "2. Update Matrix");
                System.out.print("Enter Number: ");
                int option = sc.nextInt();
                if (option == 1) {
                    System.out.print("Enter the row of the element: ");
                    int row = sc.nextInt();
                    System.out.print("Enter the column of the element: ");
                    int col = sc.nextInt();
                    System.out.print("Enter the new element: ");
                    int element = sc.nextInt();
                    float[][] old = new float[a.getRow()][a.getCol()];
                    for(int i = 0; i < a.getRow(); i++) {
                        for(int j = 0 ;j < a.getCol(); j++) {
                            old[i][j] = a.getMat()[i][j];
                        }
                    }
                    old[row][col] = element;
                    Matrix b = new Matrix(old,a.getRow(),a.getCol());
                    if (Objects.equals(a.getLabel(), "Square Matrix")){
                        if (check.SquareMatrix(b)){
                            Square matrix = new Square(old,b.getRow(),b.getRow());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Singular Matrix")){
                        if (check.Singular(b)){
                            Singular matrix = new Singular(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Column Matrix")){
                        if (check.Column(b)){
                            Column matrix = new Column(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Row Matrix")){
                        if (check.Row(b)){
                            Row matrix = new Row(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), " Scalar Matrix")){
                        if (check.Scalar(b)){
                            Scalar matrix = new Scalar(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Diagonal Matrix")){
                        if (check.Diagonal(b)){
                            Diagonal matrix = new Diagonal(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Singleton Matrix")){
                        if (check.Singleton(b)){
                            Singleton matrix = new Singleton(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Ones Matrix")){
                        if (check.OnesMatrix(b)){
                            Ones matrix = new Ones(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Null Matrix")){
                        if (check.NullMatrix(b)){
                            NullMatrix matrix = new NullMatrix(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Upper Triangular Matrix")){
                        if (check.Upper_Triangular(b)){
                            Upper_Triangular matrix = new Upper_Triangular(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Lower Triangular Matrix")){
                        if (check.Lower_Triangular(b)){
                            Lower_Triangular matrix = new Lower_Triangular(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Identity Matrix")){
                        if (check.Identity(b)){
                            Identity matrix = new Identity(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Rectangular Matrix")){
                        if (check.Rectangular(b)){
                            Rectangular matrix = new Rectangular(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Symmetric Matrix")){
                        if (check.Symmetric(b)){
                            Symmetric matrix = new Symmetric(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Skew Symmetric Matrix")){
                        if (check.Skew_Symmetric(b)){
                            Skew_Symmetric matrix = new Skew_Symmetric(old,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                }
                else if (option == 2){
                    System.out.println("Enter the updated elements of the Matrix: ");
                    float[][] mat = new float[a.getRow()][a.getCol()];
                    for(int i = 0; i < a.getRow(); i++){
                        for(int j = 0; j < a.getCol(); j++){
                            mat[i][j] = sc.nextInt();
                        }
                    }
                    Matrix b = new Matrix(mat,a.getRow(),a.getCol());
                    if (Objects.equals(a.getLabel(), "Square Matrix")){
                        if (check.SquareMatrix(b)){
                            Square matrix = new Square(mat,b.getRow(),b.getRow());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Singular Matrix")){
                        if (check.Singular(b)){
                            Singular matrix = new Singular(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Column Matrix")){
                        if (check.Column(b)){
                            Column matrix = new Column(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Row Matrix")){
                        if (check.Row(b)){
                            Row matrix = new Row(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), " Scalar Matrix")){
                        if (check.Scalar(b)){
                            Scalar matrix = new Scalar(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Diagonal Matrix")){
                        if (check.Diagonal(b)){
                            Diagonal matrix = new Diagonal(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Singleton Matrix")){
                        if (check.Singleton(b)){
                            Singleton matrix = new Singleton(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Ones Matrix")){
                        if (check.OnesMatrix(b)){
                            Ones matrix = new Ones(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Null Matrix")){
                        if (check.NullMatrix(b)){
                            NullMatrix matrix = new NullMatrix(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Upper Triangular Matrix")){
                        if (check.Upper_Triangular(b)){
                            Upper_Triangular matrix = new Upper_Triangular(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Lower Triangular Matrix")){
                        if (check.Lower_Triangular(b)){
                            Lower_Triangular matrix = new Lower_Triangular(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Identity Matrix")){
                        if (check.Identity(b)){
                            Identity matrix = new Identity(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Rectangular Matrix")){
                        if (check.Rectangular(b)){
                            Rectangular matrix = new Rectangular(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                            continue label;
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Symmetric Matrix")){
                        if (check.Symmetric(b)){
                            Symmetric matrix = new Symmetric(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                        }
                    }
                    else if (Objects.equals(a.getLabel(), "Skew Symmetric Matrix")){
                        if (check.Skew_Symmetric(b)){
                            Skew_Symmetric matrix = new Skew_Symmetric(mat,a.getRow(),a.getCol());
                            for (int i = 0; i < count; i++) {
                                if (Objects.equals(mats[i].getName(), name)) {
                                    matrix.setName(name);
                                    mats[i] = matrix;
                                }
                            }
                        }
                        else{
                            System.out.println("This Matrix is not of the form of it's label!");
                        }
                    }
                }
                else {
                    System.out.println("Please enter a valid option!");
                    continue label;
                }
            }
            else if (choose == 4){
                Matrix a = null;
                System.out.print("Enter the name of the Matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                a.all_labels();
            }
            else if (choose == 5){
                Matrix a = null;
                Matrix b = null;
                System.out.print("Enter the name of the first Matrix: ");
                String first = s.next();
                int var = 0;
                int val = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), first)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                System.out.print("Enter the name of the second Matrix: ");
                String second = s.next();
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), second)) {
                        b = mats[i];
                        val++;
                    }
                }
                if (val == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Addition(a,b);
                result.display();
            }
            else if (choose == 6){
                Matrix a = null;
                Matrix b = null;
                System.out.print("Enter the name of the first Matrix: ");
                String first = s.next();
                int var = 0;
                int val = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), first)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                System.out.print("Enter the name of the Second matrix: ");
                String second = s.next();
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), second)) {
                        b = mats[i];
                        val++;
                    }
                }
                if (val == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Subtraction(a,b);
                result.display();
            }
            else if (choose == 7){
                Matrix a = null;
                Matrix b = null;
                System.out.print("Enter the name of the first Matrix: ");
                String first = s.next();
                int var = 0;
                int val = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), first)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                System.out.print("Enter the name of the second Matrix: ");
                String second = s.next();
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), second)) {
                        b = mats[i];
                        val++;
                    }
                }
                if (val == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Multiplication(a,b);
                result.display();
            }
            else if (choose == 8){
                Matrix a = null;
                Matrix b = null;
                System.out.print("Enter the name of the first Matrix: ");
                String first = s.next();
                int var = 0;
                int val = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), first)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                System.out.print("Enter the name of the second Matrix: ");
                String second = s.next();
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), second)) {
                        b = mats[i];
                        val++;
                    }
                }
                if (val == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Division(a,b);
                result.display();
            }
            else if (choose == 9){
                Matrix a = null;
                Matrix b = null;
                System.out.print("Enter the name of the first Matrix: ");
                String first = s.next();
                int var = 0;
                int val = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), first)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                System.out.print("Enter the name of the second Matrix: ");
                String second = s.next();
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), second)) {
                        b = mats[i];
                        val++;
                    }
                }
                if (val == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Element_wise(a,b);
                result.display();
            }
            else if (choose == 10){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Transpose(a);
                result.display();
            }
            else if (choose == 11){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.Inverse(a);
                result.display();
            }
            else if (choose == 12){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                functions.Row_wise_mean(a);
            }
            else if (choose == 13){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                functions.Column_wise_mean(a);
            }
            else if (choose == 14){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                functions.Mean(a);
            }
            else if (choose == 15){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                int len = a.getCol();
                float det = functions.Determinant(a,len);
                System.out.println("Determinant = " + det);
            }
            else if (choose == 16){
                Matrix a = null;
                Matrix b = null;
                System.out.println("Use singleton matrix in matrix operations. Do you allow using singleton matrices as a scalar value?");
                String choice = s.next();
                if (Objects.equals(choice, "no")){
                    continue label;
                }
                else if (Objects.equals(choice, "yes")){
                    System.out.print("Enter the name of the matrix: ");
                    String first = s.next();
                    int var = 0;
                    for(int i = 0; i < count; i++) {
                        if (Objects.equals(mats[i].getName(), first)) {
                            a = mats[i];
                            var++;
                        }
                    }
                    if (var == 0) {
                        System.out.println("Matrix of this name does not exist!");
                        continue label;
                    }
                    System.out.print("Enter the name of the singleton matrix: ");
                    String second = s.next();
                    int val = 0;
                    for(int i = 0; i < count; i++) {
                        if (Objects.equals(mats[i].getName(), second)) {
                            b = mats[i];
                            val++;
                        }
                    }
                    if (val == 0) {
                        System.out.println("Matrix of this name does not exist!");
                        continue label;
                    }
                    float num = functions.UseScalar(b);
                    float[][] x = new float[a.getRow()][a.getCol()];
                    for(int i = 0; i < a.getRow(); i++){
                        for(int j = 0; j < a.getCol(); j++){
                            x[i][j] = a.getMat()[i][j] * num;
                        }
                    }
                    Matrix result = new Matrix(x,a.getRow(),a.getCol());
                    result.display();
                }
                else{
                    System.out.println("Please answer 'yes' or 'no'!");
                }
            }
            else if (choose == 18){
                Matrix a = null;
                System.out.print("Enter the name of the matrix: ");
                String name = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), name)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                float[] arr = functions.Eigen_Values(a);
                if (arr != null) {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                }
                else{
                    System.out.println("Cannot compute for this Matrix!");
                }
            }
            else if (choose == 19){
                Matrix a = null;
                Matrix b = null;
                System.out.print("Enter the name of the matrix: ");
                String first = s.next();
                int var = 0;
                for(int i = 0; i < count; i++) {
                    if (Objects.equals(mats[i].getName(), first)) {
                        a = mats[i];
                        var++;
                    }
                }
                if (var == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                System.out.print("Choose a column matrix and it should have same number of rows as the one entered just now");
                String second = s.next();
                int val = 0;
                int r = 0;
                for(int i = 0; i < count; i++) {
                        if (Objects.equals(mats[i].getName(), second)) {
                            b = mats[i];
                            val++;
                            if (mats[i].getRow() == b.getRow()){
                                r++;
                            }
                        }
                }
                if (val == 0) {
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                if (r == 0){
                    System.out.println("Matrix of this name does not exist!");
                    continue label;
                }
                Matrix result = functions.LinearEquation(a,b);
                result.display();
            }
            else{
                System.out.println("Please enter a valid task!");
            }

        }
    }
}
