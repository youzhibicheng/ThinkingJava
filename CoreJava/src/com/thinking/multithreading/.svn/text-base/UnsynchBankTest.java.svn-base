package com.thinking.multithreading;

/** 
   This program shows data corruption when multiple threads access a data structure.
*/
public class UnsynchBankTest
{  
   public static void main(String[] args)
   {  
      UnsynchBank b = new UnsynchBank(NACCOUNTS, INITIAL_BALANCE);
      int i;
      for (i = 0; i < NACCOUNTS; i++)
      {  
         UnsynchTransferRunnable r = new UnsynchTransferRunnable(b, i, INITIAL_BALANCE);
         Thread t = new Thread(r);
         t.start();
      }
   }

   public static final int NACCOUNTS = 100;
   public static final double INITIAL_BALANCE = 1000;
}

/**
   A UnsynchBank with a number of UnsynchBank accounts.
*/
class UnsynchBank
{ 
   /**
      Constructs the UnsynchBank.
      @param n the number of accounts
      @param initialBalance the initial balance
      for each account
   */
   public UnsynchBank(int n, double initialBalance)
   {  
      accounts = new double[n];
      for (int i = 0; i < accounts.length; i++)
         accounts[i] = initialBalance;
   }

   /**
      Transfers money from one account to another.
      @param from the account to transfer from
      @param to the account to transfer to
      @param amount the amount to transfer
   */
   public void transfer(int from, int to, double amount)
   {  
      if (accounts[from] < amount) return;
      System.out.print(Thread.currentThread());      
      accounts[from] -= amount;
      System.out.printf(" %10.2f from %d to %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
   }

   /**
      Gets the sum of all account balances.
      @return the total balance
   */
   public double getTotalBalance()
   {  
      double sum = 0;

      for (double a : accounts)
         sum += a;

      return sum;
   }

   /**
      Gets the number of accounts in the UnsynchBank.
      @return the number of accounts
   */
   public int size()
   {
      return accounts.length;
   }

   private final double[] accounts;
}

/**
   A runnable that transfers money from an account to other
   accounts in a UnsynchBank.
*/
class UnsynchTransferRunnable implements Runnable
{ 
   /**
      Constructs a transfer runnable.
      @param b the UnsynchBank between whose account money is transferred
      @param from the account to transfer money from
      @param max the maximum amount of money in each transfer 
   */
   public UnsynchTransferRunnable(UnsynchBank b, int from, double max)
   {  
      bank = b;
      fromAccount = from;
      maxAmount = max;
   }

   public void run()
   {  
      try
      {  
         while (true)
         {  
            int toAccount = (int) (bank.size() * Math.random());
            double amount = maxAmount * Math.random();
            bank.transfer(fromAccount, toAccount, amount);
            Thread.sleep((int) (DELAY * Math.random()));
         }
      }
      catch (InterruptedException e) {}
   }

   private UnsynchBank bank;
   private int fromAccount;
   private double maxAmount;
   private int DELAY = 10;
}

