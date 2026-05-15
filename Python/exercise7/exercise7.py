import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

import pytest

def get_crypto_data():
    return pd.DataFrame({
        "Day": [1, 2, 3, 4, 5, 6, 7],
        "Bitcoin": [40000, 42000, 41000, 45000, 44000, 46000, 48000],
        "Ethereum": [2500, 2600, 2550, 2800, 2750, 2900, 3100]
    })

def task_1_trend_line():
    print("--- Task 1: Building a Trend Line ---")
    df = get_crypto_data()
    plt.plot(df)
    plt.title("Bitcoin Prices Over 7 Days")
    plt.xlabel("Day")
    plt.ylabel("Price")
    plt.show()
    pass

def task_2_seaborn_comparison():
    print("--- Task 2: Seaborn Comparison ---")
    data = {
        "Portfolios": ["Portfolio A", "Portfolio B", "Portfolio C"],
        "Total Value": [10000, 15000, 25000]
    }
    df = pd.DataFrame(data)

    plt.figure(figsize = (8,4))
    sns.barplot(x="Portfolios", y="Total Value", data=df)
    plt.title("Total Value Across Portfolios")
    plt.show()
    pass

def identify_trend(start_price, end_price):
    if end_price > start_price:
        return "bullish"
    elif end_price < start_price:
        return "bearish"
    else:
        return "flat"

def test_bullish_trend():
    assert identify_trend(100, 150) == "bullish"

def test_bearish_trend():
    assert identify_trend(150, 100) == "bearish"

def test_flat_trend():
    assert identify_trend(150, 150) == "flat"

if __name__ == "__main__":
    task_1_trend_line()
    task_2_seaborn_comparison()
    pass
