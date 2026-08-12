package com.example.careercraft.ml;
public class CareerModel {
    public static double[] score(double[] input) {
        double[] var0;
        if (input[3] <= 6.5) {
            if (input[7] <= 1.5) {
                if (input[1] <= 6.5) {
                    if (input[7] <= 0.5) {
                        if (input[0] <= 5.5) {
                            var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[0] <= 6.5) {
                                if (input[5] <= 5.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.4, 0.6, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var0 = new double[] {0.9090909090909091, 0.09090909090909091, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.9900497512437811, 0.009950248756218905, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 6.5) {
                            if (input[3] <= 4.5) {
                                if (input[3] <= 3.5) {
                                    var0 = new double[] {0.21875, 0.78125, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.6666666666666666, 0.0, 0.0, 0.3333333333333333};
                                }
                            } else {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[0] <= 7.5) {
                                if (input[8] <= 0.5) {
                                    var0 = new double[] {0.5, 0.5, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.8518518518518519, 0.14814814814814814, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 0.5) {
                                    var0 = new double[] {0.875, 0.125, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.984375, 0.015625, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[5] <= 6.5) {
                        if (input[4] <= 2.5) {
                            if (input[0] <= 6.5) {
                                if (input[3] <= 5.5) {
                                    var0 = new double[] {0.03968253968253968, 0.9126984126984127, 0.0, 0.047619047619047616};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[7] <= 0.5) {
                                    var0 = new double[] {0.9302325581395349, 0.06976744186046512, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.6271186440677966, 0.3728813559322034, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[0] <= 6.5) {
                                    var0 = new double[] {0.00373134328358209, 0.8917910447761195, 0.0, 0.10447761194029852};
                                } else {
                                    var0 = new double[] {0.45161290322580644, 0.532258064516129, 0.0, 0.016129032258064516};
                                }
                            } else {
                                if (input[2] <= 4.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.45614035087719296, 0.543859649122807, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 6.5) {
                            if (input[4] <= 3.5) {
                                if (input[3] <= 4.5) {
                                    var0 = new double[] {0.04, 0.85, 0.0, 0.11};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var0 = new double[] {0.0, 0.5833333333333334, 0.0, 0.4166666666666667};
                                } else {
                                    var0 = new double[] {0.0, 0.043478260869565216, 0.0, 0.9565217391304348};
                                }
                            }
                        } else {
                            if (input[8] <= 1.5) {
                                if (input[0] <= 7.5) {
                                    var0 = new double[] {0.3170731707317074, 0.5853658536585367, 0.0, 0.09756097560975611};
                                } else {
                                    var0 = new double[] {0.9024390243902439, 0.0975609756097561, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var0 = new double[] {0.75, 0.25, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.9655172413793104, 0.034482758620689655, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[0] <= 7.5) {
                        if (input[1] <= 5.5) {
                            if (input[4] <= 5.0) {
                                if (input[5] <= 7.0) {
                                    var0 = new double[] {0.14285714285714285, 0.8571428571428571, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[3] <= 2.5) {
                                    var0 = new double[] {0.09090909090909091, 0.9090909090909091, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.17647058823529413, 0.38235294117647056, 0.0, 0.4411764705882353};
                                }
                            } else {
                                if (input[4] <= 7.5) {
                                    var0 = new double[] {0.012048192771084338, 0.07228915662650602, 0.0, 0.9156626506024096};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.8, 0.2};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 8.5) {
                            if (input[4] <= 2.5) {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[3] <= 2.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.42857142857142855, 0.5714285714285714, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[8] <= 1.5) {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[5] <= 5.0) {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[5] <= 6.5) {
                        if (input[6] <= 1.5) {
                            if (input[0] <= 4.5) {
                                if (input[2] <= 4.0) {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.044444444444444446, 0.0, 0.9555555555555556};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var0 = new double[] {0.0, 0.55, 0.0, 0.45};
                                } else {
                                    var0 = new double[] {0.0, 0.4090909090909091, 0.0, 0.5909090909090909};
                                }
                            }
                        } else {
                            if (input[4] <= 1.5) {
                                if (input[3] <= 2.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 5.5) {
                                    var0 = new double[] {0.06451612903225806, 0.6774193548387096, 0.0, 0.25806451612903225};
                                } else {
                                    var0 = new double[] {0.047619047619047616, 0.38095238095238093, 0.0, 0.5714285714285714};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 2.5) {
                            if (input[6] <= 2.5) {
                                if (input[4] <= 4.5) {
                                    var0 = new double[] {0.0, 0.5, 0.0, 0.5};
                                } else {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[4] <= 3.5) {
                                    var0 = new double[] {0.0, 0.5, 0.0, 0.5};
                                } else {
                                    var0 = new double[] {0.0, 0.10344827586206896, 0.0, 0.896551724137931};
                                }
                            } else {
                                if (input[5] <= 8.5) {
                                    var0 = new double[] {0.004694835680751174, 0.004694835680751174, 0.0, 0.9906103286384976};
                                } else {
                                    var0 = new double[] {0.028037383177570093, 0.0, 0.0, 0.9719626168224299};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[1] <= 7.5) {
                if (input[4] <= 4.0) {
                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                } else {
                    if (input[1] <= 6.5) {
                        var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        if (input[4] <= 6.5) {
                            if (input[3] <= 7.5) {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[7] <= 1.5) {
                                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.5, 0.5};
                                }
                            }
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            } else {
                if (input[2] <= 4.5) {
                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                } else {
                    if (input[1] <= 8.5) {
                        if (input[4] <= 8.0) {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                    }
                }
            }
        }
        double[] var1;
        if (input[4] <= 6.5) {
            if (input[3] <= 4.5) {
                if (input[8] <= 1.5) {
                    if (input[0] <= 7.5) {
                        if (input[3] <= 3.5) {
                            if (input[5] <= 7.5) {
                                if (input[1] <= 6.5) {
                                    var1 = new double[] {0.4666666666666667, 0.45, 0.0, 0.08333333333333333};
                                } else {
                                    var1 = new double[] {0.07126948775055679, 0.8485523385300668, 0.0, 0.0801781737193764};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var1 = new double[] {0.1, 0.8, 0.0, 0.1};
                                } else {
                                    var1 = new double[] {0.08928571428571429, 0.23214285714285715, 0.0, 0.6785714285714286};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                if (input[5] <= 7.5) {
                                    var1 = new double[] {0.0, 0.17142857142857143, 0.0, 0.8285714285714286};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[0] <= 3.5) {
                                    var1 = new double[] {0.0, 0.2, 0.0, 0.8};
                                } else {
                                    var1 = new double[] {0.06748466257668712, 0.4601226993865031, 0.0, 0.4723926380368098};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 6.5) {
                            if (input[1] <= 6.5) {
                                if (input[4] <= 2.5) {
                                    var1 = new double[] {0.9166666666666666, 0.08333333333333333, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var1 = new double[] {0.6341463414634146, 0.36585365853658536, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.40425531914893614, 0.5957446808510638, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[5] <= 7.5) {
                                    var1 = new double[] {0.8524590163934426, 0.14754098360655737, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var1 = new double[] {0.3333333333333333, 0.0, 0.0, 0.6666666666666666};
                                } else {
                                    var1 = new double[] {0.9166666666666666, 0.0, 0.0, 0.08333333333333333};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        if (input[1] <= 6.5) {
                            if (input[0] <= 6.5) {
                                if (input[6] <= 1.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 7.5) {
                                    var1 = new double[] {0.9813664596273292, 0.018633540372670808, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.9375, 0.0625, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 0.5) {
                                if (input[0] <= 6.5) {
                                    var1 = new double[] {0.15384615384615385, 0.8461538461538461, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.9885057471264368, 0.011494252873563218, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var1 = new double[] {0.030303030303030304, 0.9090909090909091, 0.0, 0.06060606060606061};
                                } else {
                                    var1 = new double[] {0.8913043478260869, 0.10869565217391304, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 6.5) {
                            if (input[7] <= 1.5) {
                                if (input[4] <= 4.5) {
                                    var1 = new double[] {0.04225352112676056, 0.9154929577464789, 0.0, 0.04225352112676056};
                                } else {
                                    var1 = new double[] {0.0, 0.5625, 0.0, 0.4375};
                                }
                            } else {
                                if (input[5] <= 7.5) {
                                    var1 = new double[] {0.0, 0.5952380952380952, 0.0, 0.40476190476190477};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[2] <= 8.5) {
                                if (input[0] <= 7.5) {
                                    var1 = new double[] {0.5588235294117647, 0.4411764705882353, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.8596491228070176, 0.07017543859649122, 0.0, 0.07017543859649122};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var1 = new double[] {0.23076923076923078, 0.7692307692307693, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.4, 0.0, 0.6};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 6.5) {
                    if (input[5] <= 7.5) {
                        if (input[0] <= 6.0) {
                            if (input[1] <= 5.5) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[6] <= 2.5) {
                            if (input[0] <= 6.5) {
                                if (input[4] <= 3.5) {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.9833333333333333, 0.016666666666666666};
                                }
                            } else {
                                if (input[5] <= 8.5) {
                                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    }
                } else {
                    if (input[0] <= 7.5) {
                        if (input[3] <= 8.5) {
                            if (input[6] <= 2.5) {
                                if (input[7] <= 0.5) {
                                    var1 = new double[] {0.0196078431372549, 0.09803921568627451, 0.0, 0.8823529411764706};
                                } else {
                                    var1 = new double[] {0.0, 0.0045871559633027525, 0.0022935779816513763, 0.9931192660550459};
                                }
                            } else {
                                if (input[3] <= 5.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    } else {
                        if (input[3] <= 5.5) {
                            if (input[6] <= 1.5) {
                                if (input[4] <= 2.0) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.8, 0.2, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                }
            }
        } else {
            if (input[4] <= 7.5) {
                if (input[0] <= 5.5) {
                    if (input[2] <= 7.5) {
                        if (input[5] <= 6.5) {
                            if (input[8] <= 1.5) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[1] <= 7.5) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[6] <= 2.5) {
                            if (input[0] <= 4.5) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[6] <= 0.5) {
                                    var1 = new double[] {0.0, 0.0, 0.5714285714285714, 0.42857142857142855};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                } else {
                    if (input[7] <= 0.5) {
                        var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                    } else {
                        if (input[0] <= 6.5) {
                            if (input[3] <= 6.5) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[5] <= 9.0) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[2] <= 6.5) {
                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                } else {
                    if (input[4] <= 8.5) {
                        if (input[3] <= 6.5) {
                            if (input[1] <= 6.5) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            }
        }
        double[] var2;
        if (input[1] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[5] <= 5.5) {
                    if (input[6] <= 0.5) {
                        if (input[0] <= 4.5) {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[8] <= 1.0) {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[5] <= 4.5) {
                            if (input[3] <= 3.5) {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    }
                } else {
                    if (input[7] <= 0.5) {
                        if (input[3] <= 5.5) {
                            if (input[0] <= 5.5) {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            }
                        } else {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[1] <= 5.5) {
                            if (input[3] <= 5.5) {
                                if (input[6] <= 1.0) {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[5] <= 6.5) {
                                if (input[3] <= 5.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 6.5) {
                                    var2 = new double[] {0.18181818181818182, 0.18181818181818182, 0.09090909090909091, 0.5454545454545454};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[5] <= 7.5) {
                    if (input[0] <= 7.5) {
                        if (input[2] <= 9.5) {
                            if (input[6] <= 1.5) {
                                if (input[7] <= 1.5) {
                                    var2 = new double[] {0.6923076923076923, 0.3076923076923077, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.8695652173913043, 0.13043478260869565, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[4] <= 2.5) {
                                if (input[0] <= 8.5) {
                                    var2 = new double[] {0.9318181818181818, 0.06818181818181818, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 2.5) {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[0] <= 8.5) {
                                    var2 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[7] <= 1.5) {
                        if (input[3] <= 6.5) {
                            var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                        } else {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[8] <= 0.5) {
                            if (input[1] <= 5.0) {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[4] <= 5.5) {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            }
        } else {
            if (input[7] <= 1.5) {
                if (input[0] <= 6.5) {
                    if (input[4] <= 4.5) {
                        if (input[2] <= 7.5) {
                            if (input[0] <= 5.5) {
                                if (input[0] <= 1.5) {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var2 = new double[] {0.004405286343612335, 0.7929515418502202, 0.0, 0.2026431718061674};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var2 = new double[] {0.17333333333333334, 0.8, 0.0, 0.02666666666666667};
                                } else {
                                    var2 = new double[] {0.0851063829787234, 0.8936170212765957, 0.0, 0.02127659574468085};
                                }
                            }
                        } else {
                            if (input[0] <= 5.5) {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.0, 0.3157894736842105, 0.0, 0.6842105263157895};
                                } else {
                                    var2 = new double[] {0.0, 0.6724137931034483, 0.0, 0.3275862068965517};
                                }
                            } else {
                                if (input[3] <= 4.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.1111111111111111, 0.0, 0.8888888888888888};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 4.5) {
                            if (input[2] <= 6.5) {
                                if (input[5] <= 8.5) {
                                    var2 = new double[] {0.0, 0.9393939393939394, 0.0, 0.06060606060606061};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[2] <= 7.5) {
                                    var2 = new double[] {0.0, 0.07142857142857142, 0.0, 0.9285714285714286};
                                } else {
                                    var2 = new double[] {0.0, 0.4230769230769231, 0.0, 0.5769230769230769};
                                }
                            }
                        } else {
                            if (input[1] <= 7.5) {
                                if (input[4] <= 5.5) {
                                    var2 = new double[] {0.0, 0.5, 0.0, 0.5};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                } else {
                    if (input[8] <= 1.5) {
                        if (input[4] <= 3.5) {
                            if (input[0] <= 8.5) {
                                if (input[4] <= 1.5) {
                                    var2 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.4918032786885246, 0.4918032786885246, 0.0, 0.01639344262295082};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.7741935483870968, 0.22580645161290322, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.3939393939393939, 0.6060606060606061, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var2 = new double[] {0.16666666666666666, 0.5, 0.0, 0.3333333333333333};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 8.5) {
                            if (input[5] <= 6.5) {
                                if (input[1] <= 7.5) {
                                    var2 = new double[] {0.8709677419354839, 0.12903225806451613, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.4166666666666667, 0.5833333333333334, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.7272727272727273, 0.24242424242424243, 0.0, 0.030303030303030304};
                                }
                            }
                        } else {
                            if (input[4] <= 3.5) {
                                if (input[5] <= 7.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.9411764705882353, 0.058823529411764705, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 7.5) {
                                    var2 = new double[] {0.75, 0.25, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[3] <= 3.5) {
                    if (input[5] <= 7.5) {
                        if (input[8] <= 1.5) {
                            if (input[0] <= 7.5) {
                                if (input[3] <= 2.5) {
                                    var2 = new double[] {0.023255813953488372, 0.8837209302325582, 0.0, 0.09302325581395349};
                                } else {
                                    var2 = new double[] {0.03571428571428571, 0.6071428571428571, 0.0, 0.35714285714285715};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var2 = new double[] {0.8, 0.2, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.25, 0.75, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 8.5) {
                                if (input[4] <= 2.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.5384615384615384, 0.38461538461538464, 0.0, 0.07692307692307693};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.6, 0.0, 0.4};
                                }
                            }
                        }
                    } else {
                        if (input[2] <= 6.5) {
                            if (input[3] <= 1.5) {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[3] <= 2.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.2857142857142857, 0.0, 0.0, 0.7142857142857143};
                                }
                            }
                        } else {
                            if (input[2] <= 8.5) {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[1] <= 9.5) {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        if (input[3] <= 6.5) {
                            if (input[0] <= 7.5) {
                                if (input[2] <= 2.5) {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.08235294117647059, 0.0, 0.9176470588235294};
                                }
                            } else {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[4] <= 6.5) {
                                if (input[6] <= 0.5) {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.6, 0.4};
                                }
                            } else {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    } else {
                        if (input[2] <= 3.5) {
                            if (input[6] <= 1.5) {
                                if (input[3] <= 6.5) {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 1.0) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 9.0) {
                                if (input[4] <= 8.5) {
                                    var2 = new double[] {0.006864988558352402, 0.004576659038901602, 0.002288329519450801, 0.9862700228832952};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            }
        }
        double[] var3;
        if (input[1] <= 6.5) {
            if (input[1] <= 5.5) {
                if (input[0] <= 6.5) {
                    if (input[5] <= 5.5) {
                        if (input[7] <= 1.0) {
                            if (input[6] <= 2.5) {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[5] <= 6.5) {
                            if (input[3] <= 6.0) {
                                if (input[0] <= 5.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                } else {
                    if (input[2] <= 9.5) {
                        if (input[3] <= 7.0) {
                            if (input[6] <= 0.5) {
                                if (input[5] <= 4.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                    }
                }
            } else {
                if (input[3] <= 6.5) {
                    if (input[6] <= 0.5) {
                        if (input[0] <= 7.0) {
                            if (input[8] <= 0.5) {
                                if (input[2] <= 6.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 7.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        } else {
                            var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[4] <= 4.5) {
                            if (input[0] <= 6.5) {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.16666666666666666, 0.8055555555555556, 0.0, 0.027777777777777776};
                                } else {
                                    var3 = new double[] {0.625, 0.375, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 5.5) {
                                    var3 = new double[] {0.9655172413793104, 0.034482758620689655, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.5, 0.0, 0.0, 0.5};
                                }
                            }
                        } else {
                            if (input[3] <= 2.5) {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                }
            }
        } else {
            if (input[7] <= 1.5) {
                if (input[0] <= 7.5) {
                    if (input[5] <= 6.5) {
                        if (input[2] <= 7.5) {
                            if (input[0] <= 6.5) {
                                if (input[2] <= 6.5) {
                                    var3 = new double[] {0.0049504950495049506, 0.9851485148514851, 0.0, 0.009900990099009901};
                                } else {
                                    var3 = new double[] {0.009615384615384616, 0.9326923076923077, 0.0, 0.057692307692307696};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.30357142857142855, 0.6964285714285714, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.6923076923076923, 0.3076923076923077, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[3] <= 4.5) {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.04504504504504504, 0.9099099099099099, 0.0, 0.04504504504504504};
                                } else {
                                    var3 = new double[] {0.35714285714285715, 0.6428571428571429, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.0, 0.14285714285714285, 0.0, 0.8571428571428571};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 4.5) {
                            if (input[3] <= 2.5) {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.0410958904109589, 0.9178082191780822, 0.0, 0.0410958904109589};
                                } else {
                                    var3 = new double[] {0.4166666666666667, 0.5833333333333334, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 4.5) {
                                    var3 = new double[] {0.2079207920792079, 0.5445544554455446, 0.0, 0.24752475247524752};
                                } else {
                                    var3 = new double[] {0.0, 0.32142857142857145, 0.0, 0.6785714285714286};
                                }
                            }
                        } else {
                            if (input[1] <= 7.5) {
                                if (input[0] <= 2.5) {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.34782608695652173, 0.6521739130434783};
                                }
                            } else {
                                if (input[4] <= 8.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[0] <= 8.5) {
                        if (input[5] <= 6.5) {
                            if (input[2] <= 5.5) {
                                if (input[3] <= 3.5) {
                                    var3 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var3 = new double[] {0.4, 0.6, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.7058823529411765, 0.23529411764705882, 0.0, 0.058823529411764705};
                                }
                            }
                        } else {
                            if (input[8] <= 0.5) {
                                if (input[5] <= 7.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.6, 0.2, 0.0, 0.2};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var3 = new double[] {0.98, 0.02, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.625, 0.125, 0.0, 0.25};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 3.5) {
                            if (input[1] <= 8.5) {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[2] <= 9.0) {
                                if (input[3] <= 3.5) {
                                    var3 = new double[] {0.5333333333333333, 0.4666666666666667, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[5] <= 6.5) {
                    if (input[3] <= 3.5) {
                        if (input[1] <= 9.5) {
                            if (input[5] <= 5.5) {
                                if (input[4] <= 2.5) {
                                    var3 = new double[] {0.18181818181818182, 0.8181818181818182, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.08823529411764706, 0.7058823529411765, 0.0, 0.20588235294117646};
                                } else {
                                    var3 = new double[] {0.8571428571428571, 0.14285714285714285, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 5.5) {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.5, 0.0, 0.5};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.3333333333333333, 0.0, 0.6666666666666666};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 4.5) {
                            if (input[0] <= 7.5) {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.0, 0.12, 0.0, 0.88};
                                } else {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 6.5) {
                                if (input[3] <= 4.5) {
                                    var3 = new double[] {0.0, 0.07407407407407407, 0.0, 0.9259259259259259};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[2] <= 5.0) {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        if (input[4] <= 6.5) {
                            if (input[3] <= 3.5) {
                                if (input[6] <= 1.5) {
                                    var3 = new double[] {0.1, 0.2, 0.0, 0.7};
                                } else {
                                    var3 = new double[] {0.8571428571428571, 0.14285714285714285, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var3 = new double[] {0.0, 0.018867924528301886, 0.018867924528301886, 0.9622641509433962};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[3] <= 6.5) {
                                    var3 = new double[] {0.0, 0.0, 0.42857142857142855, 0.5714285714285714};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 8.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 7.5) {
                            if (input[0] <= 6.5) {
                                if (input[5] <= 7.5) {
                                    var3 = new double[] {0.0, 0.08130081300813008, 0.0, 0.9186991869918699};
                                } else {
                                    var3 = new double[] {0.0, 0.003937007874015748, 0.0, 0.9960629921259843};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.06521739130434782, 0.15217391304347827, 0.0, 0.782608695652174};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 5.5) {
                                var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            }
        }
        return mulVectorNumber(addVectors(addVectors(addVectors(addVectors(subroutine0(input), var0), var1), var2), var3), 0.05);
    }
    public static double[] subroutine0(double[] input) {
        double[] var0;
        if (input[4] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[3] <= 3.5) {
                    if (input[7] <= 1.5) {
                        if (input[1] <= 5.5) {
                            if (input[0] <= 5.5) {
                                var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[6] <= 1.5) {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.8571428571428571, 0.14285714285714285, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 5.5) {
                                if (input[5] <= 6.5) {
                                    var0 = new double[] {0.0, 0.996078431372549, 0.0, 0.00392156862745098};
                                } else {
                                    var0 = new double[] {0.011764705882352941, 0.8117647058823529, 0.0, 0.17647058823529413};
                                }
                            } else {
                                if (input[1] <= 6.5) {
                                    var0 = new double[] {0.5625, 0.4375, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0763888888888889, 0.9097222222222222, 0.0, 0.013888888888888888};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 4.5) {
                            if (input[4] <= 3.5) {
                                if (input[2] <= 6.5) {
                                    var0 = new double[] {0.0, 0.375, 0.0, 0.625};
                                } else {
                                    var0 = new double[] {0.0, 0.8, 0.0, 0.2};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var0 = new double[] {0.0, 0.7272727272727273, 0.0, 0.2727272727272727};
                                } else {
                                    var0 = new double[] {0.0, 0.06666666666666667, 0.0, 0.9333333333333333};
                                }
                            }
                        } else {
                            if (input[2] <= 7.5) {
                                if (input[6] <= 1.5) {
                                    var0 = new double[] {0.0, 0.6666666666666666, 0.0, 0.3333333333333333};
                                } else {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var0 = new double[] {0.5714285714285714, 0.2857142857142857, 0.0, 0.14285714285714285};
                                } else {
                                    var0 = new double[] {0.0, 0.15789473684210525, 0.0, 0.8421052631578947};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 5.5) {
                        if (input[4] <= 4.0) {
                            if (input[2] <= 5.5) {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[3] <= 4.5) {
                            if (input[5] <= 6.5) {
                                if (input[6] <= 0.5) {
                                    var0 = new double[] {0.0, 0.13333333333333333, 0.0, 0.8666666666666667};
                                } else {
                                    var0 = new double[] {0.07766990291262135, 0.6310679611650486, 0.0, 0.2912621359223301};
                                }
                            } else {
                                if (input[2] <= 6.5) {
                                    var0 = new double[] {0.0, 0.28205128205128205, 0.0, 0.717948717948718};
                                } else {
                                    var0 = new double[] {0.009615384615384616, 0.009615384615384616, 0.0, 0.9807692307692307};
                                }
                            }
                        } else {
                            if (input[3] <= 8.5) {
                                if (input[3] <= 7.5) {
                                    var0 = new double[] {0.0, 0.017543859649122806, 0.0021929824561403508, 0.9802631578947368};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.16666666666666666, 0.8333333333333334};
                                }
                            } else {
                                if (input[2] <= 6.5) {
                                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.6666666666666666, 0.3333333333333333};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[0] <= 8.5) {
                    if (input[1] <= 6.5) {
                        if (input[6] <= 1.5) {
                            if (input[4] <= 3.5) {
                                if (input[8] <= 1.5) {
                                    var0 = new double[] {0.7894736842105263, 0.21052631578947367, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.90625, 0.09375, 0.0, 0.0};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var0 = new double[] {0.375, 0.25, 0.375, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[8] <= 0.5) {
                                if (input[4] <= 3.5) {
                                    var0 = new double[] {0.9411764705882353, 0.058823529411764705, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 6.5) {
                                    var0 = new double[] {0.9636363636363636, 0.03636363636363636, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 5.5) {
                            if (input[8] <= 1.5) {
                                if (input[8] <= 0.5) {
                                    var0 = new double[] {0.125, 0.875, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.33962264150943394, 0.660377358490566, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var0 = new double[] {0.8181818181818182, 0.18181818181818182, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.4444444444444444, 0.5555555555555556, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 2.5) {
                                if (input[7] <= 1.5) {
                                    var0 = new double[] {0.8899082568807339, 0.11009174311926606, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.5384615384615384, 0.15384615384615385, 0.0, 0.3076923076923077};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var0 = new double[] {0.5811965811965812, 0.36752136752136755, 0.0, 0.05128205128205128};
                                } else {
                                    var0 = new double[] {0.18032786885245902, 0.14754098360655737, 0.0, 0.6721311475409836};
                                }
                            }
                        }
                    }
                } else {
                    if (input[4] <= 3.5) {
                        if (input[1] <= 7.5) {
                            if (input[7] <= 1.5) {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[1] <= 6.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.8, 0.2, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[7] <= 0.5) {
                                    var0 = new double[] {0.25, 0.75, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.9565217391304348, 0.043478260869565216, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 6.5) {
                            var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                        } else {
                            if (input[2] <= 4.0) {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[6] <= 1.5) {
                                    var0 = new double[] {0.16666666666666666, 0.8333333333333334, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.7142857142857143, 0.2857142857142857, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[3] <= 5.5) {
                if (input[0] <= 5.5) {
                    if (input[4] <= 8.5) {
                        var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                } else {
                    if (input[1] <= 8.0) {
                        if (input[2] <= 6.5) {
                            var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    } else {
                        var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                    }
                }
            } else {
                if (input[1] <= 8.5) {
                    if (input[1] <= 7.5) {
                        if (input[2] <= 9.5) {
                            if (input[2] <= 6.5) {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[0] <= 2.5) {
                                    var0 = new double[] {0.0, 0.0, 0.975, 0.025};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 6.5) {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[3] <= 7.5) {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                } else {
                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                }
            }
        }
        double[] var1;
        if (input[6] <= 1.5) {
            if (input[4] <= 6.5) {
                if (input[0] <= 7.5) {
                    if (input[1] <= 5.5) {
                        if (input[4] <= 4.0) {
                            if (input[8] <= 0.5) {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[5] <= 6.5) {
                            if (input[3] <= 4.5) {
                                if (input[6] <= 0.5) {
                                    var1 = new double[] {0.06756756756756757, 0.581081081081081, 0.0, 0.35135135135135137};
                                } else {
                                    var1 = new double[] {0.04830917874396135, 0.8647342995169082, 0.0, 0.08695652173913043};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var1 = new double[] {0.0, 0.0136986301369863, 0.0, 0.9863013698630136};
                                } else {
                                    var1 = new double[] {0.0, 0.125, 0.0, 0.875};
                                }
                            }
                        } else {
                            if (input[1] <= 6.5) {
                                if (input[0] <= 5.5) {
                                    var1 = new double[] {0.0, 0.22222222222222224, 0.40740740740740744, 0.3703703703703704};
                                } else {
                                    var1 = new double[] {0.8571428571428571, 0.0, 0.14285714285714285, 0.0};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var1 = new double[] {0.07766990291262135, 0.4563106796116505, 0.0, 0.46601941747572817};
                                } else {
                                    var1 = new double[] {0.0, 0.03731343283582089, 0.004975124378109453, 0.9577114427860697};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        if (input[2] <= 7.5) {
                            if (input[5] <= 4.5) {
                                if (input[2] <= 6.5) {
                                    var1 = new double[] {0.8, 0.2, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var1 = new double[] {0.9193548387096774, 0.08064516129032258, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[5] <= 5.5) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.33333333333333337, 0.5000000000000001, 0.0, 0.16666666666666669};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            if (input[8] <= 0.5) {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[3] <= 1.5) {
                                    var1 = new double[] {0.4, 0.6, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.7391304347826088, 0.2173913043478261, 0.0, 0.04347826086956522};
                                }
                            }
                        } else {
                            if (input[4] <= 2.5) {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[0] <= 8.5) {
                                    var1 = new double[] {0.08333333333333333, 0.16666666666666666, 0.0, 0.75};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[7] <= 0.5) {
                        if (input[1] <= 6.5) {
                            var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[2] <= 9.5) {
                            if (input[0] <= 5.5) {
                                if (input[5] <= 7.5) {
                                    var1 = new double[] {0.0, 0.0, 0.9875, 0.0125};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.9979879275653923, 0.002012072434607646};
                                }
                            } else {
                                if (input[1] <= 6.5) {
                                    var1 = new double[] {0.0, 0.0, 0.975609756097561, 0.024390243902439025};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[0] <= 4.5) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                } else {
                    if (input[2] <= 5.0) {
                        var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        if (input[3] <= 7.0) {
                            var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        } else {
            if (input[0] <= 6.5) {
                if (input[3] <= 4.5) {
                    if (input[3] <= 3.5) {
                        if (input[1] <= 6.5) {
                            if (input[7] <= 1.5) {
                                if (input[4] <= 1.5) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.3548387096774194, 0.6451612903225806, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[5] <= 6.5) {
                                    var1 = new double[] {0.005747126436781609, 0.9942528735632183, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.1566265060240964, 0.8072289156626506, 0.0, 0.03614457831325301};
                                }
                            } else {
                                if (input[2] <= 9.5) {
                                    var1 = new double[] {0.01639344262295082, 0.7704918032786885, 0.0, 0.21311475409836064};
                                } else {
                                    var1 = new double[] {0.0, 0.2, 0.0, 0.8};
                                }
                            }
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[2] <= 8.5) {
                                if (input[6] <= 2.5) {
                                    var1 = new double[] {0.047619047619047616, 0.9523809523809523, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.4444444444444444, 0.5555555555555556, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[5] <= 5.5) {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[6] <= 3.0) {
                                    var1 = new double[] {0.0, 0.10344827586206896, 0.0, 0.896551724137931};
                                } else {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 6.5) {
                        if (input[7] <= 0.5) {
                            if (input[2] <= 6.0) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 5.5) {
                                if (input[1] <= 4.5) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[1] <= 5.5) {
                                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.9285714285714286, 0.07142857142857142};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 7.5) {
                            if (input[3] <= 7.5) {
                                if (input[5] <= 4.0) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.1, 0.0, 0.9};
                                }
                            } else {
                                if (input[5] <= 7.5) {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 8.0) {
                                if (input[0] <= 4.5) {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var1 = new double[] {0.0, 0.018518518518518517, 0.0, 0.9814814814814815};
                                }
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 6.5) {
                    if (input[3] <= 7.5) {
                        if (input[7] <= 1.5) {
                            if (input[0] <= 8.5) {
                                if (input[2] <= 6.5) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.9111111111111111, 0.08888888888888889, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[5] <= 7.5) {
                                if (input[8] <= 0.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                } else {
                    if (input[2] <= 5.5) {
                        if (input[3] <= 4.5) {
                            if (input[7] <= 0.5) {
                                if (input[8] <= 0.5) {
                                    var1 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.9655172413793104, 0.034482758620689655, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var1 = new double[] {0.75, 0.25, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[8] <= 1.5) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 8.5) {
                            if (input[5] <= 5.5) {
                                if (input[6] <= 2.5) {
                                    var1 = new double[] {0.17777777777777778, 0.8, 0.0, 0.022222222222222223};
                                } else {
                                    var1 = new double[] {0.7, 0.3, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 4.5) {
                                    var1 = new double[] {0.7128712871287128, 0.25742574257425743, 0.0, 0.0297029702970297};
                                } else {
                                    var1 = new double[] {0.25, 0.0, 0.0, 0.75};
                                }
                            }
                        } else {
                            if (input[0] <= 9.5) {
                                if (input[2] <= 8.5) {
                                    var1 = new double[] {0.926829268292683, 0.07317073170731707, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.6, 0.4, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            }
        }
        double[] var2;
        if (input[1] <= 6.5) {
            if (input[7] <= 1.5) {
                if (input[3] <= 6.5) {
                    if (input[0] <= 5.5) {
                        if (input[0] <= 2.0) {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[2] <= 6.5) {
                            if (input[4] <= 3.5) {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.95, 0.05, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.9881656804733728, 0.011834319526627219, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 4.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.7619047619047619, 0.23809523809523808, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 5.5) {
                                if (input[2] <= 9.5) {
                                    var2 = new double[] {0.9833333333333333, 0.016666666666666666, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var2 = new double[] {0.9347826086956522, 0.06521739130434782, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.7894736842105263, 0.21052631578947367, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                }
            } else {
                if (input[4] <= 4.5) {
                    if (input[3] <= 3.5) {
                        if (input[5] <= 4.5) {
                            var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[4] <= 2.5) {
                                if (input[4] <= 1.5) {
                                    var2 = new double[] {0.8333333333333334, 0.16666666666666666, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 6.0) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.8461538461538461, 0.15384615384615385, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 6.0) {
                            var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            if (input[8] <= 0.5) {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.75, 0.0, 0.0, 0.25};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[2] <= 7.5) {
                        if (input[1] <= 5.5) {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[0] <= 5.5) {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[5] <= 8.5) {
                                    var2 = new double[] {0.0, 0.5, 0.0, 0.5};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 5.5) {
                            if (input[8] <= 0.5) {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        } else {
            if (input[3] <= 3.5) {
                if (input[0] <= 6.5) {
                    if (input[5] <= 6.5) {
                        if (input[1] <= 9.5) {
                            if (input[7] <= 1.5) {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.08536585365853659, 0.9146341463414634, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 9.5) {
                                    var2 = new double[] {0.0, 0.8888888888888888, 0.0, 0.1111111111111111};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[3] <= 1.5) {
                                if (input[2] <= 8.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[0] <= 5.5) {
                                    var2 = new double[] {0.0, 0.8529411764705882, 0.0, 0.14705882352941177};
                                } else {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[4] <= 4.5) {
                                if (input[4] <= 2.5) {
                                    var2 = new double[] {0.19047619047619047, 0.7380952380952381, 0.0, 0.07142857142857142};
                                } else {
                                    var2 = new double[] {0.02127659574468085, 0.9148936170212766, 0.0, 0.06382978723404255};
                                }
                            } else {
                                if (input[2] <= 7.5) {
                                    var2 = new double[] {0.0, 0.6086956521739131, 0.0, 0.391304347826087};
                                } else {
                                    var2 = new double[] {0.0, 0.14285714285714285, 0.0, 0.8571428571428571};
                                }
                            }
                        } else {
                            if (input[0] <= 4.5) {
                                if (input[4] <= 3.5) {
                                    var2 = new double[] {0.0, 0.375, 0.0, 0.625};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.09090909090909091, 0.29545454545454547, 0.0, 0.6136363636363636};
                                }
                            }
                        }
                    }
                } else {
                    if (input[8] <= 1.5) {
                        if (input[6] <= 2.5) {
                            if (input[5] <= 5.5) {
                                if (input[6] <= 0.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.27586206896551724, 0.7241379310344828, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 1.5) {
                                    var2 = new double[] {0.9411764705882353, 0.058823529411764705, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.47572815533980584, 0.42718446601941745, 0.0, 0.0970873786407767};
                                }
                            }
                        } else {
                            if (input[5] <= 5.5) {
                                if (input[1] <= 7.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.25, 0.75, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 4.5) {
                            if (input[2] <= 6.5) {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.42857142857142855, 0.5714285714285714, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[2] <= 9.5) {
                                if (input[5] <= 5.5) {
                                    var2 = new double[] {0.8064516129032258, 0.1935483870967742, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.9516129032258065, 0.04838709677419355, 0.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[0] <= 7.5) {
                        if (input[3] <= 6.5) {
                            if (input[3] <= 4.5) {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.0, 0.3548387096774194, 0.0, 0.6451612903225806};
                                } else {
                                    var2 = new double[] {0.6842105263157895, 0.3157894736842105, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var2 = new double[] {0.02666666666666667, 0.0, 0.02666666666666667, 0.9466666666666667};
                                } else {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 5.5) {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[2] <= 7.5) {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.8333333333333334, 0.16666666666666666};
                                }
                            }
                        }
                    } else {
                        if (input[2] <= 5.5) {
                            var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                        } else {
                            if (input[5] <= 5.5) {
                                if (input[2] <= 8.0) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[7] <= 1.5) {
                        if (input[4] <= 3.5) {
                            if (input[3] <= 4.5) {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.29166666666666674, 0.5416666666666667, 0.0, 0.16666666666666669};
                                } else {
                                    var2 = new double[] {0.6551724137931034, 0.3448275862068966, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var2 = new double[] {0.25, 0.1, 0.0, 0.65};
                                }
                            }
                        } else {
                            if (input[3] <= 4.5) {
                                if (input[8] <= 0.5) {
                                    var2 = new double[] {0.0, 0.5833333333333334, 0.0, 0.4166666666666667};
                                } else {
                                    var2 = new double[] {0.1111111111111111, 0.25, 0.0, 0.6388888888888888};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var2 = new double[] {0.0, 0.009900990099009901, 0.019801980198019802, 0.9702970297029703};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 7.5) {
                            if (input[3] <= 4.5) {
                                if (input[2] <= 2.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.01282051282051282, 0.08974358974358974, 0.0, 0.8974358974358975};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.0, 0.005319148936170213, 0.0, 0.9946808510638298};
                                } else {
                                    var2 = new double[] {0.058823529411764705, 0.0, 0.0, 0.9411764705882353};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                }
            }
        }
        double[] var3;
        if (input[1] <= 6.5) {
            if (input[3] <= 5.5) {
                if (input[5] <= 5.5) {
                    if (input[6] <= 1.5) {
                        if (input[7] <= 1.5) {
                            if (input[1] <= 4.5) {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[0] <= 7.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.9090909090909091, 0.09090909090909091, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 5.0) {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[8] <= 0.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.3333333333333333, 0.0, 0.0, 0.6666666666666666};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 2.5) {
                            if (input[2] <= 8.5) {
                                if (input[4] <= 1.5) {
                                    var3 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[8] <= 1.5) {
                                if (input[1] <= 5.5) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.5625, 0.4375, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.8333333333333334, 0.16666666666666666, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[0] <= 5.5) {
                        if (input[5] <= 7.5) {
                            if (input[3] <= 3.5) {
                                if (input[0] <= 4.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.25, 0.75, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 5.0) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.3333333333333333, 0.0, 0.6666666666666666};
                                }
                            }
                        } else {
                            if (input[2] <= 5.5) {
                                if (input[2] <= 4.0) {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[0] <= 6.5) {
                            if (input[8] <= 1.5) {
                                if (input[4] <= 2.0) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[8] <= 0.5) {
                                if (input[3] <= 3.5) {
                                    var3 = new double[] {0.9411764705882353, 0.058823529411764705, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.625, 0.125, 0.0, 0.25};
                                }
                            } else {
                                if (input[2] <= 7.5) {
                                    var3 = new double[] {0.9953703703703703, 0.004629629629629629, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.9361702127659575, 0.06382978723404255, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[4] <= 4.5) {
                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                } else {
                    if (input[7] <= 1.5) {
                        if (input[5] <= 6.5) {
                            if (input[3] <= 7.0) {
                                var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[3] <= 6.5) {
                            if (input[8] <= 1.5) {
                                if (input[1] <= 5.5) {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[4] <= 6.0) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        } else {
                            var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        } else {
            if (input[3] <= 3.5) {
                if (input[0] <= 6.5) {
                    if (input[7] <= 1.5) {
                        if (input[5] <= 6.5) {
                            if (input[2] <= 5.5) {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[6] <= 0.5) {
                                    var3 = new double[] {0.05263157894736842, 0.8947368421052632, 0.0, 0.05263157894736842};
                                } else {
                                    var3 = new double[] {0.011363636363636364, 0.9886363636363636, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                if (input[1] <= 8.5) {
                                    var3 = new double[] {0.0, 0.8571428571428571, 0.0, 0.14285714285714285};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[0] <= 2.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.039603960396039604, 0.8514851485148515, 0.0, 0.10891089108910891};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 2.5) {
                            if (input[5] <= 8.0) {
                                if (input[2] <= 9.5) {
                                    var3 = new double[] {0.021739130434782608, 0.8695652173913043, 0.0, 0.10869565217391304};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[2] <= 5.5) {
                                if (input[5] <= 7.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[0] <= 5.5) {
                                    var3 = new double[] {0.0, 0.31645569620253167, 0.0, 0.6835443037974683};
                                } else {
                                    var3 = new double[] {0.0, 0.6666666666666666, 0.0, 0.3333333333333333};
                                }
                            }
                        }
                    }
                } else {
                    if (input[0] <= 7.5) {
                        if (input[8] <= 1.5) {
                            if (input[2] <= 4.5) {
                                if (input[1] <= 7.5) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 5.5) {
                                    var3 = new double[] {0.20930232558139536, 0.7558139534883721, 0.0, 0.03488372093023256};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[5] <= 5.5) {
                                if (input[4] <= 2.5) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.1, 0.9, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var3 = new double[] {0.875, 0.125, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 6.5) {
                            if (input[1] <= 8.5) {
                                if (input[1] <= 7.5) {
                                    var3 = new double[] {0.8354430379746836, 0.16455696202531644, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var3 = new double[] {0.7, 0.3, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[8] <= 0.5) {
                                if (input[6] <= 2.5) {
                                    var3 = new double[] {0.5, 0.5, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var3 = new double[] {0.9852941176470589, 0.014705882352941176, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.8363636363636363, 0.10909090909090909, 0.0, 0.05454545454545454};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[7] <= 1.5) {
                    if (input[4] <= 3.5) {
                        if (input[5] <= 5.5) {
                            if (input[8] <= 1.5) {
                                if (input[2] <= 6.5) {
                                    var3 = new double[] {0.2857142857142857, 0.7142857142857143, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.9375, 0.0, 0.0625};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.7894736842105263, 0.21052631578947367, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.08333333333333333, 0.23333333333333334, 0.0, 0.6833333333333333};
                                } else {
                                    var3 = new double[] {0.5882352941176471, 0.11764705882352941, 0.0, 0.29411764705882354};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var3 = new double[] {0.18518518518518517, 0.25925925925925924, 0.0, 0.5555555555555556};
                                } else {
                                    var3 = new double[] {0.9838709677419355, 0.016129032258064516, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 4.5) {
                            if (input[2] <= 6.5) {
                                if (input[2] <= 5.5) {
                                    var3 = new double[] {0.14285714285714285, 0.7857142857142857, 0.0, 0.07142857142857142};
                                } else {
                                    var3 = new double[] {0.8333333333333334, 0.0, 0.0, 0.16666666666666666};
                                }
                            } else {
                                if (input[0] <= 3.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.058823529411764705, 0.4411764705882353, 0.0, 0.5};
                                }
                            }
                        } else {
                            if (input[1] <= 7.5) {
                                if (input[4] <= 5.5) {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 8.0) {
                                    var3 = new double[] {0.027777777777777776, 0.0, 0.0, 0.9722222222222222};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[3] <= 7.5) {
                        if (input[0] <= 7.5) {
                            if (input[5] <= 6.5) {
                                if (input[2] <= 4.5) {
                                    var3 = new double[] {0.0, 0.5, 0.5, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.13013698630136986, 0.0, 0.8698630136986302};
                                }
                            } else {
                                if (input[4] <= 7.5) {
                                    var3 = new double[] {0.0, 0.0025906735751295338, 0.0, 0.9974093264248705};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.6666666666666666, 0.3333333333333333};
                                }
                            }
                        } else {
                            if (input[3] <= 5.5) {
                                if (input[4] <= 3.5) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.2, 0.0, 0.0, 0.8};
                                }
                            } else {
                                var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[4] <= 5.5) {
                            var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        }
        double[] var4;
        if (input[3] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[5] <= 6.5) {
                    if (input[3] <= 3.5) {
                        if (input[3] <= 2.5) {
                            if (input[7] <= 1.5) {
                                if (input[8] <= 1.5) {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.015625, 0.984375, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 3.5) {
                                    var4 = new double[] {0.0, 0.6, 0.0, 0.4};
                                } else {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 6.5) {
                                if (input[6] <= 2.5) {
                                    var4 = new double[] {0.25, 0.6666666666666666, 0.0, 0.08333333333333333};
                                } else {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var4 = new double[] {0.04597701149425287, 0.7816091954022989, 0.0, 0.1724137931034483};
                                } else {
                                    var4 = new double[] {0.019417475728155338, 0.9805825242718447, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[6] <= 2.5) {
                            if (input[7] <= 0.5) {
                                if (input[3] <= 4.5) {
                                    var4 = new double[] {0.0, 0.8461538461538461, 0.0, 0.15384615384615385};
                                } else {
                                    var4 = new double[] {0.0, 0.1, 0.0, 0.9};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var4 = new double[] {0.0, 0.09, 0.0, 0.91};
                                } else {
                                    var4 = new double[] {0.0, 0.39285714285714285, 0.0, 0.6071428571428571};
                                }
                            }
                        } else {
                            if (input[0] <= 5.5) {
                                if (input[5] <= 5.5) {
                                    var4 = new double[] {0.0, 0.8888888888888888, 0.0, 0.1111111111111111};
                                } else {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[4] <= 7.5) {
                        if (input[0] <= 5.5) {
                            if (input[7] <= 1.5) {
                                if (input[5] <= 7.5) {
                                    var4 = new double[] {0.012048192771084338, 0.4457831325301205, 0.0, 0.5421686746987951};
                                } else {
                                    var4 = new double[] {0.0, 0.17142857142857143, 0.009523809523809525, 0.819047619047619};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var4 = new double[] {0.07692307692307693, 0.3076923076923077, 0.0, 0.6153846153846154};
                                } else {
                                    var4 = new double[] {0.0, 0.01775147928994083, 0.026627218934911243, 0.9556213017751479};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                if (input[1] <= 6.5) {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.0, 0.125, 0.0, 0.875};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var4 = new double[] {0.13793103448275862, 0.7413793103448276, 0.0, 0.1206896551724138};
                                } else {
                                    var4 = new double[] {0.0, 0.1590909090909091, 0.0, 0.8409090909090909};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 8.5) {
                            var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[1] <= 6.0) {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[8] <= 1.5) {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 6.5) {
                    if (input[7] <= 1.5) {
                        if (input[4] <= 4.5) {
                            if (input[6] <= 2.5) {
                                var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[0] <= 7.5) {
                                    var4 = new double[] {0.925, 0.075, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[2] <= 5.5) {
                                var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[7] <= 0.5) {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 8.5) {
                            if (input[3] <= 5.5) {
                                if (input[8] <= 0.5) {
                                    var4 = new double[] {0.0, 0.5, 0.0, 0.5};
                                } else {
                                    var4 = new double[] {0.9375, 0.0625, 0.0, 0.0};
                                }
                            } else {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    }
                } else {
                    if (input[4] <= 3.5) {
                        if (input[8] <= 1.5) {
                            if (input[0] <= 8.5) {
                                if (input[0] <= 7.5) {
                                    var4 = new double[] {0.39603960396039606, 0.504950495049505, 0.0, 0.09900990099009901};
                                } else {
                                    var4 = new double[] {0.627450980392157, 0.33333333333333337, 0.0, 0.03921568627450981};
                                }
                            } else {
                                if (input[5] <= 7.5) {
                                    var4 = new double[] {0.9787234042553191, 0.02127659574468085, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.8823529411764706, 0.0, 0.0, 0.11764705882352941};
                                }
                            }
                        } else {
                            if (input[1] <= 8.5) {
                                if (input[3] <= 4.5) {
                                    var4 = new double[] {0.9620253164556962, 0.0379746835443038, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.7142857142857143, 0.0, 0.0, 0.2857142857142857};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var4 = new double[] {0.4, 0.6, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.7837837837837838, 0.16216216216216217, 0.0, 0.05405405405405406};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            if (input[2] <= 5.5) {
                                if (input[0] <= 7.5) {
                                    var4 = new double[] {0.2857142857142857, 0.7142857142857143, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.9411764705882353, 0.058823529411764705, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var4 = new double[] {0.43243243243243246, 0.5675675675675675, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.12, 0.84, 0.0, 0.04};
                                }
                            }
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[2] <= 6.5) {
                                    var4 = new double[] {0.5263157894736842, 0.05263157894736842, 0.0, 0.42105263157894735};
                                } else {
                                    var4 = new double[] {0.10638297872340426, 0.02127659574468085, 0.0, 0.8723404255319149};
                                }
                            } else {
                                if (input[2] <= 7.0) {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[1] <= 7.5) {
                if (input[4] <= 3.5) {
                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                } else {
                    if (input[4] <= 5.5) {
                        if (input[3] <= 7.5) {
                            var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            if (input[2] <= 6.5) {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[0] <= 4.5) {
                                    var4 = new double[] {0.0, 0.0, 0.3333333333333333, 0.6666666666666666};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 6.5) {
                            var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[2] <= 7.5) {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[0] <= 5.0) {
                                    var4 = new double[] {0.0, 0.0, 0.5, 0.5};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[4] <= 8.0) {
                    if (input[8] <= 1.5) {
                        var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        if (input[5] <= 10.0) {
                            var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            if (input[2] <= 7.5) {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                } else {
                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                }
            }
        }
        return addVectors(addVectors(addVectors(addVectors(addVectors(subroutine1(input), var0), var1), var2), var3), var4);
    }
    public static double[] subroutine1(double[] input) {
        double[] var0;
        if (input[3] <= 6.5) {
            if (input[1] <= 7.5) {
                if (input[6] <= 2.5) {
                    if (input[7] <= 1.5) {
                        if (input[1] <= 6.5) {
                            if (input[1] <= 5.5) {
                                if (input[6] <= 0.5) {
                                    var0 = new double[] {0.5833333333333334, 0.25, 0.16666666666666666, 0.0};
                                } else {
                                    var0 = new double[] {0.9310344827586208, 0.03448275862068966, 0.03448275862068966, 0.0};
                                }
                            } else {
                                if (input[5] <= 2.5) {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.6910112359550562, 0.3089887640449438, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[3] <= 4.5) {
                                if (input[8] <= 1.5) {
                                    var0 = new double[] {0.22602739726027396, 0.7123287671232876, 0.0, 0.06164383561643835};
                                } else {
                                    var0 = new double[] {0.6612903225806451, 0.33064516129032256, 0.0, 0.008064516129032258};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var0 = new double[] {0.0, 0.11764705882352941, 0.0, 0.8823529411764706};
                                } else {
                                    var0 = new double[] {0.8571428571428571, 0.0, 0.0, 0.14285714285714285};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 5.5) {
                            if (input[0] <= 6.5) {
                                if (input[4] <= 5.0) {
                                    var0 = new double[] {0.0, 0.5, 0.0, 0.5};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[5] <= 6.5) {
                                if (input[2] <= 8.5) {
                                    var0 = new double[] {0.2727272727272727, 0.6, 0.0, 0.12727272727272726};
                                } else {
                                    var0 = new double[] {0.07692307692307693, 0.15384615384615385, 0.0, 0.7692307692307693};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var0 = new double[] {0.47058823529411764, 0.29411764705882354, 0.0, 0.23529411764705882};
                                } else {
                                    var0 = new double[] {0.06862745098039216, 0.09803921568627451, 0.00980392156862745, 0.8235294117647058};
                                }
                            }
                        }
                    }
                } else {
                    if (input[8] <= 1.5) {
                        if (input[4] <= 4.5) {
                            if (input[3] <= 1.5) {
                                if (input[1] <= 6.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.25, 0.75, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var0 = new double[] {0.2222222222222222, 0.7777777777777778, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.9473684210526315, 0.05263157894736842, 0.0, 0.0};
                                }
                            }
                        } else {
                            var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[0] <= 5.0) {
                            var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[3] <= 2.5) {
                                if (input[1] <= 6.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.92, 0.08, 0.0, 0.0};
                                }
                            } else {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[3] <= 3.5) {
                    if (input[5] <= 6.5) {
                        if (input[6] <= 1.5) {
                            if (input[0] <= 7.5) {
                                if (input[2] <= 9.5) {
                                    var0 = new double[] {0.012345679012345678, 0.9320987654320988, 0.0, 0.05555555555555555};
                                } else {
                                    var0 = new double[] {0.0, 0.5, 0.0, 0.5};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.5555555555555556, 0.4444444444444444, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[2] <= 2.5) {
                                var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[7] <= 0.5) {
                                    var0 = new double[] {0.3645833333333333, 0.6354166666666666, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.15447154471544716, 0.8373983739837398, 0.0, 0.008130081300813009};
                                }
                            }
                        }
                    } else {
                        if (input[6] <= 2.5) {
                            if (input[0] <= 7.5) {
                                if (input[4] <= 4.5) {
                                    var0 = new double[] {0.013888888888888888, 0.75, 0.0, 0.2361111111111111};
                                } else {
                                    var0 = new double[] {0.0, 0.1836734693877551, 0.0, 0.8163265306122449};
                                }
                            } else {
                                if (input[7] <= 0.5) {
                                    var0 = new double[] {0.9, 0.1, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.6923076923076923, 0.3076923076923077, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[0] <= 4.5) {
                                    var0 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.9743589743589743, 0.02564102564102564, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var0 = new double[] {0.5, 0.5, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[7] <= 1.5) {
                        if (input[3] <= 4.5) {
                            if (input[5] <= 5.5) {
                                if (input[8] <= 1.5) {
                                    var0 = new double[] {0.06451612903225806, 0.8709677419354839, 0.0, 0.06451612903225806};
                                } else {
                                    var0 = new double[] {0.42857142857142855, 0.5714285714285714, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 6.5) {
                                    var0 = new double[] {0.5483870967741935, 0.3548387096774194, 0.0, 0.0967741935483871};
                                } else {
                                    var0 = new double[] {0.22641509433962265, 0.18867924528301888, 0.0, 0.5849056603773585};
                                }
                            }
                        } else {
                            if (input[5] <= 6.5) {
                                if (input[6] <= 2.5) {
                                    var0 = new double[] {0.14285714285714285, 0.05714285714285714, 0.0, 0.8};
                                } else {
                                    var0 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                }
                            } else {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[2] <= 2.0) {
                            var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                        } else {
                            if (input[0] <= 8.5) {
                                if (input[1] <= 8.5) {
                                    var0 = new double[] {0.005405405405405406, 0.06486486486486487, 0.0, 0.9297297297297298};
                                } else {
                                    var0 = new double[] {0.0, 0.00904977375565611, 0.0, 0.9909502262443439};
                                }
                            } else {
                                if (input[4] <= 4.5) {
                                    var0 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[5] <= 7.5) {
                if (input[2] <= 6.5) {
                    if (input[3] <= 7.5) {
                        if (input[4] <= 4.5) {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[1] <= 7.5) {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                } else {
                    if (input[3] <= 7.5) {
                        if (input[5] <= 6.5) {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[4] <= 7.0) {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 5.5) {
                            if (input[3] <= 9.5) {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[4] <= 4.0) {
                        var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        if (input[4] <= 5.5) {
                            if (input[1] <= 6.5) {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                } else {
                    if (input[3] <= 7.5) {
                        var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        if (input[1] <= 8.5) {
                            if (input[0] <= 4.5) {
                                var0 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var0 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                }
            }
        }
        double[] var1;
        if (input[1] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[1] <= 5.5) {
                    if (input[0] <= 5.5) {
                        if (input[3] <= 5.5) {
                            if (input[8] <= 0.5) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[4] <= 5.5) {
                            if (input[1] <= 4.5) {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[2] <= 6.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                } else {
                    if (input[5] <= 7.5) {
                        if (input[6] <= 0.5) {
                            if (input[3] <= 6.5) {
                                if (input[3] <= 3.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.25, 0.75};
                                }
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 5.0) {
                                if (input[2] <= 5.5) {
                                    var1 = new double[] {0.4166666666666667, 0.5833333333333334, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0625, 0.875, 0.0, 0.0625};
                                }
                            } else {
                                if (input[3] <= 6.5) {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[2] <= 6.5) {
                            if (input[3] <= 5.0) {
                                if (input[6] <= 0.5) {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[4] <= 5.5) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[3] <= 7.0) {
                    if (input[8] <= 0.5) {
                        if (input[2] <= 9.5) {
                            if (input[5] <= 8.5) {
                                if (input[0] <= 8.5) {
                                    var1 = new double[] {0.9655172413793104, 0.034482758620689655, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[7] <= 1.0) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[3] <= 1.5) {
                            if (input[4] <= 2.5) {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[4] <= 3.5) {
                                    var1 = new double[] {0.8181818181818182, 0.18181818181818182, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[5] <= 5.5) {
                                if (input[0] <= 7.5) {
                                    var1 = new double[] {0.8181818181818182, 0.18181818181818182, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.9879518072289156, 0.012048192771084338, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var1 = new double[] {0.9948717948717949, 0.005128205128205128, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.9629629629629629, 0.037037037037037035, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                }
            }
        } else {
            if (input[3] <= 3.5) {
                if (input[0] <= 6.5) {
                    if (input[5] <= 7.5) {
                        if (input[7] <= 1.5) {
                            if (input[5] <= 6.5) {
                                if (input[5] <= 4.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0199203187250996, 0.9760956175298805, 0.0, 0.00398406374501992};
                                }
                            } else {
                                if (input[4] <= 4.5) {
                                    var1 = new double[] {0.05454545454545454, 0.9272727272727272, 0.0, 0.01818181818181818};
                                } else {
                                    var1 = new double[] {0.0, 0.4, 0.0, 0.6};
                                }
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[3] <= 2.5) {
                                    var1 = new double[] {0.0, 0.9, 0.0, 0.1};
                                } else {
                                    var1 = new double[] {0.0, 0.3333333333333333, 0.0, 0.6666666666666666};
                                }
                            } else {
                                if (input[2] <= 9.5) {
                                    var1 = new double[] {0.04651162790697675, 0.9069767441860466, 0.0, 0.04651162790697675};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[4] <= 4.5) {
                                if (input[2] <= 6.5) {
                                    var1 = new double[] {0.0, 0.8666666666666667, 0.0, 0.13333333333333333};
                                } else {
                                    var1 = new double[] {0.2, 0.65, 0.0, 0.15};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.2, 0.0, 0.8};
                                }
                            }
                        } else {
                            if (input[4] <= 1.5) {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[1] <= 7.5) {
                                    var1 = new double[] {0.0, 0.4, 0.0, 0.6};
                                } else {
                                    var1 = new double[] {0.0, 0.05714285714285714, 0.0, 0.9428571428571428};
                                }
                            }
                        }
                    }
                } else {
                    if (input[5] <= 5.5) {
                        if (input[6] <= 2.5) {
                            if (input[4] <= 2.5) {
                                if (input[8] <= 0.5) {
                                    var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.8, 0.2, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var1 = new double[] {0.16666666666666666, 0.8333333333333334, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.06666666666666667, 0.9333333333333333, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[8] <= 1.5) {
                                if (input[2] <= 6.0) {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.16666666666666666, 0.8333333333333334, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var1 = new double[] {0.7, 0.3, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 9.5) {
                            if (input[0] <= 7.5) {
                                if (input[2] <= 4.5) {
                                    var1 = new double[] {0.875, 0.125, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.55, 0.45, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var1 = new double[] {0.8880597014925373, 0.1044776119402985, 0.0, 0.007462686567164179};
                                } else {
                                    var1 = new double[] {0.6222222222222222, 0.37777777777777777, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[5] <= 7.5) {
                                var1 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[6] <= 3.0) {
                                    var1 = new double[] {0.125, 0.125, 0.0, 0.75};
                                } else {
                                    var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[6] <= 2.5) {
                    if (input[4] <= 7.5) {
                        if (input[7] <= 1.5) {
                            if (input[1] <= 7.5) {
                                if (input[3] <= 4.5) {
                                    var1 = new double[] {0.7391304347826086, 0.2608695652173913, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.08333333333333333, 0.125, 0.16666666666666666, 0.625};
                                }
                            } else {
                                if (input[3] <= 4.5) {
                                    var1 = new double[] {0.1568627450980392, 0.49019607843137253, 0.0, 0.35294117647058826};
                                } else {
                                    var1 = new double[] {0.035211267605633804, 0.056338028169014086, 0.0, 0.9084507042253521};
                                }
                            }
                        } else {
                            if (input[4] <= 6.5) {
                                if (input[0] <= 7.5) {
                                    var1 = new double[] {0.0, 0.02734375, 0.005859375, 0.966796875};
                                } else {
                                    var1 = new double[] {0.3333333333333333, 0.13333333333333333, 0.0, 0.5333333333333333};
                                }
                            } else {
                                if (input[0] <= 3.5) {
                                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.375, 0.625};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 5.5) {
                            var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            if (input[4] <= 8.5) {
                                if (input[2] <= 6.5) {
                                    var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var1 = new double[] {0.0, 0.0, 0.5, 0.5};
                                }
                            } else {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[5] <= 7.5) {
                        if (input[7] <= 0.5) {
                            if (input[0] <= 5.0) {
                                var1 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 5.5) {
                                if (input[2] <= 4.5) {
                                    var1 = new double[] {0.8571428571428571, 0.14285714285714285, 0.0, 0.0};
                                } else {
                                    var1 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            } else {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[1] <= 8.5) {
                            if (input[0] <= 4.0) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[2] <= 6.5) {
                                var1 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var1 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            }
        }
        double[] var2;
        if (input[4] <= 6.5) {
            if (input[3] <= 3.5) {
                if (input[0] <= 6.5) {
                    if (input[2] <= 9.5) {
                        if (input[5] <= 7.5) {
                            if (input[7] <= 1.5) {
                                if (input[5] <= 6.5) {
                                    var2 = new double[] {0.02570694087403599, 0.9717223650385605, 0.0, 0.002570694087403599};
                                } else {
                                    var2 = new double[] {0.10810810810810811, 0.8378378378378378, 0.0, 0.05405405405405406};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var2 = new double[] {0.018867924528301886, 0.9433962264150944, 0.0, 0.03773584905660377};
                                } else {
                                    var2 = new double[] {0.0, 0.6615384615384615, 0.0, 0.3384615384615385};
                                }
                            }
                        } else {
                            if (input[4] <= 3.5) {
                                if (input[3] <= 2.5) {
                                    var2 = new double[] {0.10526315789473684, 0.8947368421052632, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.24, 0.36, 0.0, 0.4};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var2 = new double[] {0.0, 0.375, 0.0, 0.625};
                                } else {
                                    var2 = new double[] {0.0, 0.037037037037037035, 0.0, 0.9629629629629629};
                                }
                            }
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[4] <= 4.5) {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                } else {
                    if (input[6] <= 2.5) {
                        if (input[4] <= 3.5) {
                            if (input[3] <= 2.5) {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.5887850467289719, 0.3925233644859813, 0.0, 0.018691588785046728};
                                } else {
                                    var2 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var2 = new double[] {0.6333333333333333, 0.36666666666666664, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.8114285714285714, 0.16, 0.0, 0.02857142857142857};
                                }
                            }
                        } else {
                            if (input[2] <= 3.5) {
                                if (input[4] <= 4.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var2 = new double[] {0.19047619047619047, 0.7380952380952381, 0.0, 0.07142857142857142};
                                } else {
                                    var2 = new double[] {0.4444444444444444, 0.5555555555555556, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[8] <= 0.5) {
                            if (input[4] <= 3.5) {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[7] <= 0.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 5.5) {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[2] <= 4.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.9459459459459459, 0.05405405405405406, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[6] <= 2.5) {
                    if (input[1] <= 6.5) {
                        if (input[6] <= 1.5) {
                            if (input[3] <= 6.5) {
                                if (input[2] <= 5.5) {
                                    var2 = new double[] {0.2857142857142857, 0.7142857142857143, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.6315789473684211, 0.052631578947368425, 0.026315789473684213, 0.2894736842105264};
                                }
                            } else {
                                var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[0] <= 5.5) {
                                if (input[3] <= 6.5) {
                                    var2 = new double[] {0.0, 0.8, 0.0, 0.2};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[4] <= 3.5) {
                            if (input[0] <= 7.5) {
                                if (input[7] <= 0.5) {
                                    var2 = new double[] {0.13333333333333336, 0.5777777777777778, 0.0, 0.2888888888888889};
                                } else {
                                    var2 = new double[] {0.012195121951219513, 0.1016260162601626, 0.0, 0.8861788617886179};
                                }
                            } else {
                                if (input[2] <= 8.5) {
                                    var2 = new double[] {0.8867924528301887, 0.11320754716981132, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.5, 0.0, 0.5};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[3] <= 4.5) {
                                    var2 = new double[] {0.0784313725490196, 0.43137254901960786, 0.0, 0.49019607843137253};
                                } else {
                                    var2 = new double[] {0.025, 0.0375, 0.0375, 0.9};
                                }
                            } else {
                                if (input[5] <= 4.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.003215434083601286, 0.012861736334405145, 0.006430868167202572, 0.977491961414791};
                                }
                            }
                        }
                    }
                } else {
                    if (input[0] <= 6.5) {
                        if (input[1] <= 5.5) {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[3] <= 4.5) {
                                if (input[0] <= 5.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 7.5) {
                            if (input[1] <= 7.5) {
                                if (input[8] <= 0.5) {
                                    var2 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 1.5) {
                                    var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.2, 0.8, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 0.5) {
                                var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[1] <= 6.5) {
                                    var2 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var2 = new double[] {0.9166666666666666, 0.08333333333333333, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[1] <= 8.5) {
                if (input[3] <= 6.5) {
                    if (input[1] <= 5.5) {
                        var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        if (input[4] <= 7.5) {
                            if (input[5] <= 4.5) {
                                var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                } else {
                    var2 = new double[] {0.0, 0.0, 1.0, 0.0};
                }
            } else {
                if (input[3] <= 3.5) {
                    if (input[0] <= 6.0) {
                        var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        if (input[7] <= 1.0) {
                            var2 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                } else {
                    var2 = new double[] {0.0, 0.0, 0.0, 1.0};
                }
            }
        }
        double[] var3;
        if (input[3] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[3] <= 3.5) {
                    if (input[7] <= 1.5) {
                        if (input[5] <= 8.5) {
                            if (input[4] <= 4.5) {
                                if (input[0] <= 5.5) {
                                    var3 = new double[] {0.01282051282051282, 0.9700854700854701, 0.0, 0.017094017094017096};
                                } else {
                                    var3 = new double[] {0.15286624203821655, 0.8471337579617835, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 9.5) {
                                    var3 = new double[] {0.0, 0.8055555555555556, 0.0, 0.19444444444444445};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[4] <= 3.5) {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[2] <= 5.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[6] <= 1.5) {
                            if (input[3] <= 2.5) {
                                if (input[1] <= 7.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.625, 0.0, 0.375};
                                }
                            } else {
                                if (input[5] <= 5.5) {
                                    var3 = new double[] {0.0, 0.6666666666666666, 0.0, 0.3333333333333333};
                                } else {
                                    var3 = new double[] {0.0, 0.14035087719298245, 0.0, 0.8596491228070176};
                                }
                            }
                        } else {
                            if (input[3] <= 2.5) {
                                if (input[0] <= 5.5) {
                                    var3 = new double[] {0.125, 0.75, 0.0, 0.125};
                                } else {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var3 = new double[] {0.0, 0.9375, 0.0, 0.0625};
                                } else {
                                    var3 = new double[] {0.0, 0.4666666666666667, 0.0, 0.5333333333333333};
                                }
                            }
                        }
                    }
                } else {
                    if (input[4] <= 7.5) {
                        if (input[5] <= 6.5) {
                            if (input[7] <= 1.5) {
                                if (input[1] <= 7.5) {
                                    var3 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.05970149253731343, 0.4626865671641791, 0.0, 0.47761194029850745};
                                }
                            } else {
                                if (input[3] <= 4.5) {
                                    var3 = new double[] {0.0, 0.21739130434782608, 0.0, 0.782608695652174};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[4] <= 6.5) {
                                if (input[7] <= 0.5) {
                                    var3 = new double[] {0.0, 0.1875, 0.0, 0.8125};
                                } else {
                                    var3 = new double[] {0.004807692307692308, 0.009615384615384616, 0.007211538461538462, 0.9783653846153846};
                                }
                            } else {
                                if (input[1] <= 6.0) {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 5.5) {
                            if (input[7] <= 1.5) {
                                var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                if (input[1] <= 6.5) {
                                    var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[6] <= 2.5) {
                        if (input[3] <= 4.5) {
                            if (input[5] <= 5.5) {
                                if (input[7] <= 0.5) {
                                    var3 = new double[] {0.75, 0.25, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.5333333333333333, 0.4666666666666667, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var3 = new double[] {0.6923076923076923, 0.2564102564102564, 0.0, 0.05128205128205128};
                                } else {
                                    var3 = new double[] {0.9210526315789473, 0.07894736842105263, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[1] <= 6.5) {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.2, 0.2, 0.0, 0.6};
                                }
                            } else {
                                if (input[1] <= 6.5) {
                                    var3 = new double[] {0.6666666666666666, 0.0, 0.0, 0.3333333333333333};
                                } else {
                                    var3 = new double[] {0.13333333333333333, 0.0, 0.0, 0.8666666666666667};
                                }
                            }
                        }
                    } else {
                        if (input[8] <= 1.5) {
                            if (input[0] <= 7.5) {
                                if (input[2] <= 4.5) {
                                    var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.875, 0.125, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var3 = new double[] {0.9583333333333334, 0.041666666666666664, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[5] <= 4.5) {
                                if (input[3] <= 2.5) {
                                    var3 = new double[] {0.5, 0.5, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                var3 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[0] <= 7.5) {
                        if (input[3] <= 4.5) {
                            if (input[6] <= 1.5) {
                                if (input[8] <= 1.5) {
                                    var3 = new double[] {0.05, 0.65, 0.0, 0.3};
                                } else {
                                    var3 = new double[] {0.5454545454545454, 0.36363636363636365, 0.0, 0.09090909090909091};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var3 = new double[] {0.4864864864864865, 0.5, 0.0, 0.013513513513513514};
                                } else {
                                    var3 = new double[] {0.3, 0.3, 0.0, 0.4};
                                }
                            }
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[2] <= 6.5) {
                                    var3 = new double[] {0.0, 0.2, 0.0, 0.8};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var3 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[6] <= 1.5) {
                            if (input[5] <= 7.5) {
                                if (input[1] <= 8.5) {
                                    var3 = new double[] {0.6956521739130435, 0.21739130434782608, 0.0, 0.08695652173913043};
                                } else {
                                    var3 = new double[] {0.25, 0.7, 0.0, 0.05};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var3 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[4] <= 3.5) {
                                if (input[2] <= 9.5) {
                                    var3 = new double[] {0.9072164948453608, 0.08247422680412371, 0.0, 0.010309278350515464};
                                } else {
                                    var3 = new double[] {0.5555555555555556, 0.4444444444444444, 0.0, 0.0};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var3 = new double[] {0.6428571428571429, 0.35714285714285715, 0.0, 0.0};
                                } else {
                                    var3 = new double[] {0.0, 0.8571428571428571, 0.0, 0.14285714285714285};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[4] <= 4.5) {
                if (input[3] <= 8.5) {
                    var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                } else {
                    if (input[5] <= 8.0) {
                        var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            } else {
                if (input[4] <= 6.5) {
                    if (input[1] <= 7.5) {
                        var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                    }
                } else {
                    if (input[1] <= 8.5) {
                        var3 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        var3 = new double[] {0.0, 0.0, 0.0, 1.0};
                    }
                }
            }
        }
        double[] var4;
        if (input[7] <= 1.5) {
            if (input[5] <= 6.5) {
                if (input[3] <= 5.5) {
                    if (input[1] <= 6.5) {
                        if (input[0] <= 6.5) {
                            if (input[2] <= 6.5) {
                                if (input[0] <= 4.5) {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.631578947368421, 0.3684210526315789, 0.0, 0.0};
                                }
                            } else {
                                var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[0] <= 7.5) {
                                    var4 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.9696969696969697, 0.030303030303030304, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var4 = new double[] {0.896551724137931, 0.10344827586206896, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            if (input[6] <= 2.5) {
                                if (input[0] <= 6.5) {
                                    var4 = new double[] {0.006493506493506494, 0.9902597402597403, 0.0, 0.003246753246753247};
                                } else {
                                    var4 = new double[] {0.536144578313253, 0.463855421686747, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var4 = new double[] {0.5972222222222222, 0.4027777777777778, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.18181818181818182, 0.8181818181818182, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                if (input[1] <= 9.5) {
                                    var4 = new double[] {0.6666666666666666, 0.0, 0.0, 0.3333333333333333};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[0] <= 6.5) {
                                    var4 = new double[] {0.04918032786885246, 0.7049180327868853, 0.0, 0.2459016393442623};
                                } else {
                                    var4 = new double[] {0.6619718309859155, 0.323943661971831, 0.0, 0.014084507042253521};
                                }
                            }
                        }
                    }
                } else {
                    if (input[8] <= 1.5) {
                        var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                    }
                }
            } else {
                if (input[4] <= 5.5) {
                    if (input[0] <= 6.5) {
                        if (input[3] <= 3.5) {
                            if (input[1] <= 6.5) {
                                if (input[3] <= 2.5) {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 2.5) {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var4 = new double[] {0.08737864077669903, 0.7961165048543689, 0.0, 0.11650485436893204};
                                }
                            }
                        } else {
                            if (input[3] <= 4.5) {
                                if (input[0] <= 5.5) {
                                    var4 = new double[] {0.0, 0.225, 0.0, 0.775};
                                } else {
                                    var4 = new double[] {0.3, 0.5, 0.0, 0.2};
                                }
                            } else {
                                if (input[4] <= 4.5) {
                                    var4 = new double[] {0.02666666666666667, 0.0, 0.0, 0.9733333333333334};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.18181818181818182, 0.8181818181818182};
                                }
                            }
                        }
                    } else {
                        if (input[8] <= 1.5) {
                            if (input[0] <= 7.5) {
                                if (input[4] <= 3.5) {
                                    var4 = new double[] {0.6176470588235294, 0.35294117647058826, 0.0, 0.029411764705882353};
                                } else {
                                    var4 = new double[] {0.2, 0.8, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var4 = new double[] {0.8095238095238095, 0.19047619047619047, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.9541284403669725, 0.045871559633027525, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 4.5) {
                                if (input[6] <= 1.5) {
                                    var4 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.9859154929577465, 0.014084507042253521, 0.0, 0.0};
                                }
                            } else {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[3] <= 6.5) {
                        if (input[7] <= 0.5) {
                            if (input[4] <= 7.0) {
                                if (input[8] <= 0.5) {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var4 = new double[] {0.0, 0.8571428571428571, 0.0, 0.14285714285714285};
                                }
                            } else {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                if (input[0] <= 3.5) {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[4] <= 7.5) {
                            if (input[8] <= 0.5) {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[3] <= 7.5) {
                                    var4 = new double[] {0.0, 0.0, 0.4444444444444444, 0.5555555555555556};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        } else {
                            var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        } else {
            if (input[2] <= 6.5) {
                if (input[4] <= 5.5) {
                    if (input[3] <= 3.5) {
                        if (input[6] <= 1.5) {
                            if (input[1] <= 9.5) {
                                if (input[3] <= 2.5) {
                                    var4 = new double[] {0.12903225806451613, 0.8709677419354839, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.07692307692307693, 0.3076923076923077, 0.0, 0.6153846153846154};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[5] <= 7.5) {
                                    var4 = new double[] {0.32142857142857145, 0.6785714285714286, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[0] <= 7.5) {
                            if (input[3] <= 7.5) {
                                if (input[3] <= 4.5) {
                                    var4 = new double[] {0.0, 0.1951219512195122, 0.0, 0.8048780487804879};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[8] <= 0.5) {
                                if (input[6] <= 0.5) {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var4 = new double[] {0.5, 0.0, 0.0, 0.5};
                                } else {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[3] <= 6.5) {
                        if (input[0] <= 3.5) {
                            if (input[4] <= 6.5) {
                                if (input[1] <= 5.0) {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[1] <= 8.0) {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[0] <= 4.5) {
                                if (input[5] <= 10.0) {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            } else {
                if (input[4] <= 6.5) {
                    if (input[6] <= 1.5) {
                        if (input[3] <= 7.5) {
                            if (input[5] <= 4.5) {
                                var4 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[0] <= 7.5) {
                                    var4 = new double[] {0.0, 0.04153354632587859, 0.0, 0.9584664536741214};
                                } else {
                                    var4 = new double[] {0.3, 0.3, 0.0, 0.4};
                                }
                            }
                        } else {
                            if (input[1] <= 7.0) {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            if (input[0] <= 6.5) {
                                if (input[4] <= 5.5) {
                                    var4 = new double[] {0.0, 0.9024390243902439, 0.0, 0.0975609756097561};
                                } else {
                                    var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[4] <= 2.5) {
                                    var4 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var4 = new double[] {0.375, 0.5625, 0.0, 0.0625};
                                }
                            }
                        } else {
                            if (input[0] <= 7.5) {
                                if (input[5] <= 5.5) {
                                    var4 = new double[] {0.0, 0.6, 0.0, 0.4};
                                } else {
                                    var4 = new double[] {0.0, 0.028985507246376812, 0.0, 0.9710144927536232};
                                }
                            } else {
                                if (input[2] <= 7.5) {
                                    var4 = new double[] {0.25, 0.0, 0.0, 0.75};
                                } else {
                                    var4 = new double[] {0.8571428571428571, 0.0, 0.0, 0.14285714285714285};
                                }
                            }
                        }
                    }
                } else {
                    if (input[5] <= 5.0) {
                        var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        if (input[3] <= 6.5) {
                            if (input[8] <= 1.5) {
                                var4 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            var4 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        }
        double[] var5;
        if (input[4] <= 6.5) {
            if (input[1] <= 6.5) {
                if (input[7] <= 1.5) {
                    if (input[3] <= 5.5) {
                        if (input[4] <= 4.5) {
                            if (input[6] <= 1.5) {
                                if (input[0] <= 6.5) {
                                    var5 = new double[] {0.05263157894736842, 0.9473684210526315, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.9036144578313253, 0.0963855421686747, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 5.5) {
                                    var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.8704663212435233, 0.12953367875647667, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[2] <= 5.5) {
                                if (input[8] <= 1.5) {
                                    var5 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.1, 0.9, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[2] <= 6.5) {
                            var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[5] <= 7.5) {
                                var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[0] <= 6.5) {
                        if (input[1] <= 5.5) {
                            if (input[5] <= 6.5) {
                                var5 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[4] <= 4.0) {
                                    var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 5.5) {
                                if (input[5] <= 10.5) {
                                    var5 = new double[] {0.0, 0.1111111111111111, 0.05555555555555555, 0.8333333333333334};
                                } else {
                                    var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    } else {
                        if (input[4] <= 3.5) {
                            if (input[3] <= 5.5) {
                                var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[2] <= 7.5) {
                                var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[8] <= 1.5) {
                                    var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[0] <= 6.5) {
                    if (input[7] <= 1.5) {
                        if (input[3] <= 4.5) {
                            if (input[5] <= 6.5) {
                                if (input[2] <= 8.5) {
                                    var5 = new double[] {0.021917808219178082, 0.9726027397260274, 0.0, 0.005479452054794521};
                                } else {
                                    var5 = new double[] {0.0, 0.8205128205128205, 0.0, 0.1794871794871795};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var5 = new double[] {0.05982905982905983, 0.811965811965812, 0.0, 0.1282051282051282};
                                } else {
                                    var5 = new double[] {0.0, 0.3548387096774194, 0.0, 0.6451612903225806};
                                }
                            }
                        } else {
                            if (input[4] <= 5.5) {
                                if (input[6] <= 2.5) {
                                    var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var5 = new double[] {0.0, 0.5, 0.0, 0.5};
                                }
                            } else {
                                if (input[5] <= 8.5) {
                                    var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var5 = new double[] {0.0, 0.0, 0.75, 0.25};
                                }
                            }
                        }
                    } else {
                        if (input[6] <= 0.5) {
                            if (input[5] <= 3.0) {
                                var5 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[2] <= 2.0) {
                                    var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var5 = new double[] {0.0, 0.025380710659898477, 0.0, 0.9746192893401016};
                                }
                            }
                        } else {
                            if (input[2] <= 5.5) {
                                if (input[5] <= 6.5) {
                                    var5 = new double[] {0.0, 0.65, 0.0, 0.35};
                                } else {
                                    var5 = new double[] {0.0, 0.1724137931034483, 0.10344827586206896, 0.7241379310344828};
                                }
                            } else {
                                if (input[0] <= 4.5) {
                                    var5 = new double[] {0.0, 0.08928571428571429, 0.0, 0.9107142857142857};
                                } else {
                                    var5 = new double[] {0.005813953488372093, 0.29069767441860467, 0.0, 0.7034883720930233};
                                }
                            }
                        }
                    }
                } else {
                    if (input[5] <= 5.5) {
                        if (input[8] <= 1.5) {
                            if (input[0] <= 7.5) {
                                if (input[6] <= 2.5) {
                                    var5 = new double[] {0.06666666666666667, 0.9111111111111111, 0.0, 0.022222222222222223};
                                } else {
                                    var5 = new double[] {0.6153846153846154, 0.38461538461538464, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var5 = new double[] {0.7272727272727273, 0.2727272727272727, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.43243243243243246, 0.5675675675675675, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 8.5) {
                                if (input[1] <= 7.5) {
                                    var5 = new double[] {0.7142857142857143, 0.2857142857142857, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.30434782608695654, 0.6956521739130435, 0.0, 0.0};
                                }
                            } else {
                                var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[0] <= 7.5) {
                            if (input[7] <= 1.5) {
                                if (input[3] <= 6.0) {
                                    var5 = new double[] {0.625, 0.3557692307692308, 0.0, 0.019230769230769232};
                                } else {
                                    var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var5 = new double[] {0.6923076923076923, 0.15384615384615385, 0.0, 0.15384615384615385};
                                } else {
                                    var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[2] <= 8.5) {
                                    var5 = new double[] {0.8925619834710744, 0.10330578512396695, 0.0, 0.004132231404958678};
                                } else {
                                    var5 = new double[] {0.46153846153846156, 0.5384615384615384, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var5 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var5 = new double[] {0.42857142857142855, 0.14285714285714285, 0.0, 0.42857142857142855};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[3] <= 5.5) {
                if (input[8] <= 0.5) {
                    if (input[6] <= 0.5) {
                        var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                    }
                } else {
                    if (input[1] <= 8.0) {
                        if (input[2] <= 8.0) {
                            var5 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    } else {
                        var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                    }
                }
            } else {
                if (input[3] <= 6.5) {
                    if (input[2] <= 6.5) {
                        if (input[5] <= 6.5) {
                            var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    } else {
                        if (input[6] <= 1.5) {
                            if (input[1] <= 6.0) {
                                var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        if (input[3] <= 7.5) {
                            var5 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var5 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            }
        }
        double[] var6;
        if (input[1] <= 6.5) {
            if (input[3] <= 5.5) {
                if (input[8] <= 1.5) {
                    if (input[0] <= 6.5) {
                        if (input[7] <= 1.5) {
                            if (input[6] <= 0.5) {
                                var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[6] <= 0.5) {
                                var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[3] <= 2.5) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 2.5) {
                            if (input[5] <= 4.5) {
                                if (input[8] <= 0.5) {
                                    var6 = new double[] {0.16666666666666666, 0.8333333333333334, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.6, 0.4, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var6 = new double[] {0.8604651162790697, 0.13953488372093023, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 7.5) {
                                if (input[2] <= 4.5) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[7] <= 1.5) {
                        if (input[4] <= 4.5) {
                            if (input[5] <= 5.5) {
                                if (input[0] <= 7.5) {
                                    var6 = new double[] {0.6428571428571429, 0.35714285714285715, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 5.5) {
                                    var6 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.9854014598540146, 0.014598540145985401, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[5] <= 5.0) {
                                var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[4] <= 5.5) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 1.5) {
                            var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[2] <= 6.0) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.5714285714285714, 0.2857142857142857, 0.0, 0.14285714285714285};
                                }
                            } else {
                                var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[2] <= 9.5) {
                    if (input[0] <= 7.5) {
                        var6 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                    }
                } else {
                    if (input[4] <= 5.5) {
                        var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        var6 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            }
        } else {
            if (input[0] <= 6.5) {
                if (input[7] <= 1.5) {
                    if (input[5] <= 6.5) {
                        if (input[0] <= 5.5) {
                            if (input[3] <= 4.5) {
                                if (input[6] <= 0.5) {
                                    var6 = new double[] {0.0, 0.8333333333333334, 0.0, 0.16666666666666666};
                                } else {
                                    var6 = new double[] {0.0, 0.9832635983263598, 0.0, 0.016736401673640166};
                                }
                            } else {
                                if (input[1] <= 9.5) {
                                    var6 = new double[] {0.0, 0.1111111111111111, 0.0, 0.8888888888888888};
                                } else {
                                    var6 = new double[] {0.0, 0.75, 0.0, 0.25};
                                }
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[8] <= 1.5) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.1935483870967742, 0.8064516129032258, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var6 = new double[] {0.07692307692307693, 0.6153846153846154, 0.0, 0.3076923076923077};
                                } else {
                                    var6 = new double[] {0.7692307692307693, 0.23076923076923078, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[6] <= 1.5) {
                            if (input[0] <= 5.5) {
                                if (input[2] <= 3.5) {
                                    var6 = new double[] {0.0, 0.7142857142857143, 0.2857142857142857, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.16279069767441862, 0.023255813953488372, 0.813953488372093};
                                }
                            } else {
                                if (input[3] <= 4.5) {
                                    var6 = new double[] {0.0, 0.8461538461538461, 0.0, 0.15384615384615385};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[2] <= 7.5) {
                                if (input[0] <= 5.5) {
                                    var6 = new double[] {0.0, 0.66, 0.04, 0.3};
                                } else {
                                    var6 = new double[] {0.18181818181818182, 0.7878787878787878, 0.0, 0.030303030303030304};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var6 = new double[] {0.0, 0.07692307692307693, 0.0, 0.9230769230769231};
                                } else {
                                    var6 = new double[] {0.027777777777777776, 0.5833333333333334, 0.027777777777777776, 0.3611111111111111};
                                }
                            }
                        }
                    }
                } else {
                    if (input[3] <= 7.5) {
                        if (input[3] <= 3.5) {
                            if (input[5] <= 5.5) {
                                if (input[2] <= 9.5) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[0] <= 5.5) {
                                    var6 = new double[] {0.0, 0.2717391304347826, 0.0, 0.7282608695652174};
                                } else {
                                    var6 = new double[] {0.0, 0.7272727272727273, 0.0, 0.2727272727272727};
                                }
                            }
                        } else {
                            if (input[6] <= 3.5) {
                                if (input[4] <= 7.5) {
                                    var6 = new double[] {0.0, 0.0273109243697479, 0.0021008403361344537, 0.9705882352941176};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.8, 0.2};
                                }
                            } else {
                                var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[1] <= 7.5) {
                            if (input[4] <= 6.0) {
                                var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var6 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[0] <= 4.5) {
                                if (input[1] <= 8.5) {
                                    var6 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                }
            } else {
                if (input[6] <= 1.5) {
                    if (input[4] <= 3.5) {
                        if (input[8] <= 1.5) {
                            if (input[0] <= 7.5) {
                                if (input[5] <= 8.0) {
                                    var6 = new double[] {0.07142857142857142, 0.7857142857142857, 0.0, 0.14285714285714285};
                                } else {
                                    var6 = new double[] {0.5, 0.0, 0.0, 0.5};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.391304347826087, 0.5652173913043478, 0.0, 0.043478260869565216};
                                }
                            }
                        } else {
                            if (input[1] <= 8.5) {
                                if (input[0] <= 7.5) {
                                    var6 = new double[] {0.6875, 0.1875, 0.0, 0.125};
                                } else {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var6 = new double[] {0.4, 0.6, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[0] <= 8.5) {
                                if (input[5] <= 5.5) {
                                    var6 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.09523809523809523, 0.047619047619047616, 0.0, 0.8571428571428571};
                                }
                            } else {
                                var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[4] <= 3.5) {
                        if (input[8] <= 0.5) {
                            if (input[7] <= 1.5) {
                                if (input[2] <= 5.5) {
                                    var6 = new double[] {0.9411764705882353, 0.058823529411764705, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.4444444444444444, 0.5555555555555556, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[2] <= 9.5) {
                                if (input[4] <= 2.5) {
                                    var6 = new double[] {0.9273743016759777, 0.07262569832402235, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.8288288288288288, 0.15315315315315314, 0.0, 0.018018018018018018};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var6 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 5.5) {
                            if (input[2] <= 9.5) {
                                if (input[7] <= 0.5) {
                                    var6 = new double[] {0.88, 0.12, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.42857142857142855, 0.4857142857142857, 0.0, 0.08571428571428572};
                                }
                            } else {
                                var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[0] <= 7.5) {
                                var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[8] <= 0.5) {
                                    var6 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var6 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    }
                }
            }
        }
        double[] var7;
        if (input[0] <= 6.5) {
            if (input[3] <= 6.5) {
                if (input[3] <= 3.5) {
                    if (input[7] <= 1.5) {
                        if (input[0] <= 5.5) {
                            if (input[5] <= 6.5) {
                                if (input[4] <= 2.5) {
                                    var7 = new double[] {0.015151515151515152, 0.9545454545454546, 0.0, 0.030303030303030304};
                                } else {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 4.5) {
                                    var7 = new double[] {0.015873015873015872, 0.9047619047619048, 0.0, 0.07936507936507936};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[1] <= 6.5) {
                                if (input[5] <= 5.5) {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.7692307692307693, 0.23076923076923078, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var7 = new double[] {0.025, 0.975, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.5384615384615384, 0.46153846153846156, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 5.5) {
                            var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[5] <= 6.5) {
                                if (input[2] <= 9.5) {
                                    var7 = new double[] {0.0, 0.890625, 0.0, 0.109375};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var7 = new double[] {0.0, 0.8333333333333334, 0.0, 0.16666666666666666};
                                } else {
                                    var7 = new double[] {0.0, 0.2127659574468085, 0.0, 0.7872340425531915};
                                }
                            }
                        }
                    }
                } else {
                    if (input[5] <= 5.5) {
                        if (input[6] <= 2.5) {
                            if (input[3] <= 4.5) {
                                if (input[7] <= 1.5) {
                                    var7 = new double[] {0.0, 0.9230769230769231, 0.0, 0.07692307692307693};
                                } else {
                                    var7 = new double[] {0.0, 0.5625, 0.0, 0.4375};
                                }
                            } else {
                                if (input[5] <= 4.5) {
                                    var7 = new double[] {0.0, 0.2222222222222222, 0.0, 0.7777777777777778};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[0] <= 5.0) {
                                var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[1] <= 7.0) {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[6] <= 2.5) {
                                if (input[5] <= 7.5) {
                                    var7 = new double[] {0.02247191011235955, 0.25842696629213485, 0.0, 0.7191011235955056};
                                } else {
                                    var7 = new double[] {0.0, 0.02702702702702703, 0.04054054054054054, 0.9324324324324325};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var7 = new double[] {0.0, 0.75, 0.0, 0.25};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[1] <= 5.5) {
                                if (input[5] <= 8.5) {
                                    var7 = new double[] {0.0, 0.0, 0.5, 0.5};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 3.5) {
                                    var7 = new double[] {0.0, 0.0, 0.2, 0.8};
                                } else {
                                    var7 = new double[] {0.0, 0.0234192037470726, 0.0, 0.9765807962529274};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[4] <= 4.0) {
                        var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        if (input[7] <= 0.5) {
                            if (input[3] <= 7.5) {
                                if (input[1] <= 5.0) {
                                    var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[1] <= 6.5) {
                                var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[2] <= 6.5) {
                                    var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.9090909090909091, 0.09090909090909091};
                                }
                            }
                        }
                    }
                } else {
                    if (input[3] <= 8.5) {
                        if (input[3] <= 7.5) {
                            var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            if (input[5] <= 9.5) {
                                var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                if (input[2] <= 6.0) {
                                    var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            }
        } else {
            if (input[0] <= 7.5) {
                if (input[8] <= 1.5) {
                    if (input[7] <= 1.5) {
                        if (input[6] <= 2.5) {
                            if (input[1] <= 6.5) {
                                if (input[5] <= 8.0) {
                                    var7 = new double[] {0.9130434782608695, 0.08695652173913043, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 5.5) {
                                    var7 = new double[] {0.07142857142857142, 0.8809523809523809, 0.0, 0.047619047619047616};
                                } else {
                                    var7 = new double[] {0.36666666666666664, 0.5, 0.0, 0.13333333333333333};
                                }
                            }
                        } else {
                            if (input[6] <= 3.5) {
                                if (input[4] <= 3.5) {
                                    var7 = new double[] {0.8421052631578947, 0.15789473684210525, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[1] <= 6.5) {
                            if (input[3] <= 5.5) {
                                var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[4] <= 3.5) {
                                if (input[6] <= 2.5) {
                                    var7 = new double[] {0.043478260869565216, 0.34782608695652173, 0.0, 0.6086956521739131};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var7 = new double[] {0.0, 0.034482758620689655, 0.0, 0.9655172413793104};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        if (input[3] <= 5.5) {
                            if (input[1] <= 5.5) {
                                var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[6] <= 1.5) {
                                    var7 = new double[] {0.875, 0.125, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                var7 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[4] <= 4.5) {
                            if (input[7] <= 1.5) {
                                if (input[6] <= 3.5) {
                                    var7 = new double[] {0.47368421052631576, 0.5263157894736842, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var7 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                }
                            }
                        } else {
                            var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    }
                }
            } else {
                if (input[0] <= 8.5) {
                    if (input[8] <= 0.5) {
                        if (input[7] <= 0.5) {
                            if (input[6] <= 1.5) {
                                var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[4] <= 2.5) {
                                    var7 = new double[] {0.8, 0.2, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[5] <= 7.5) {
                                if (input[5] <= 6.5) {
                                    var7 = new double[] {0.2727272727272727, 0.7272727272727273, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 7.5) {
                            if (input[5] <= 5.5) {
                                if (input[2] <= 6.5) {
                                    var7 = new double[] {0.84375, 0.15625, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.55, 0.45, 0.0, 0.0};
                                }
                            } else {
                                if (input[6] <= 1.5) {
                                    var7 = new double[] {0.896551724137931, 0.10344827586206896, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.9921875, 0.0, 0.0078125, 0.0};
                                }
                            }
                        } else {
                            if (input[2] <= 5.5) {
                                if (input[3] <= 1.5) {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.9642857142857143, 0.03571428571428571, 0.0, 0.0};
                                }
                            } else {
                                if (input[4] <= 3.5) {
                                    var7 = new double[] {0.4807692307692308, 0.4807692307692308, 0.0, 0.038461538461538464};
                                } else {
                                    var7 = new double[] {0.0, 0.5714285714285714, 0.0, 0.42857142857142855};
                                }
                            }
                        }
                    }
                } else {
                    if (input[4] <= 3.5) {
                        if (input[1] <= 8.5) {
                            if (input[7] <= 1.5) {
                                var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[5] <= 4.5) {
                                    var7 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[3] <= 1.5) {
                                    var7 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[2] <= 6.5) {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 6.5) {
                            var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[5] <= 7.5) {
                                    var7 = new double[] {0.36363636363636365, 0.6363636363636364, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[6] <= 3.5) {
                                    var7 = new double[] {0.8571428571428571, 0.14285714285714285, 0.0, 0.0};
                                } else {
                                    var7 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    }
                }
            }
        }
        double[] var8;
        if (input[1] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[3] <= 4.5) {
                    if (input[7] <= 1.5) {
                        if (input[0] <= 5.5) {
                            if (input[2] <= 8.5) {
                                var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[3] <= 2.5) {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[2] <= 6.5) {
                                    var8 = new double[] {0.46153846153846156, 0.5384615384615384, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.07142857142857142, 0.9285714285714286, 0.0, 0.0};
                                }
                            } else {
                                var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[3] <= 2.5) {
                            var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[6] <= 1.5) {
                                var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        }
                    }
                } else {
                    if (input[3] <= 5.5) {
                        if (input[6] <= 0.5) {
                            var8 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                        }
                    } else {
                        if (input[0] <= 5.5) {
                            var8 = new double[] {0.0, 0.0, 1.0, 0.0};
                        } else {
                            if (input[5] <= 6.0) {
                                var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var8 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[4] <= 6.5) {
                    if (input[8] <= 1.5) {
                        if (input[0] <= 8.5) {
                            if (input[6] <= 1.5) {
                                if (input[0] <= 7.5) {
                                    var8 = new double[] {0.8333333333333334, 0.16666666666666666, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.5, 0.5, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var8 = new double[] {0.8461538461538461, 0.15384615384615385, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.9622641509433962, 0.03773584905660377, 0.0, 0.0};
                                }
                            }
                        } else {
                            var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    } else {
                        if (input[6] <= 1.5) {
                            if (input[5] <= 4.5) {
                                if (input[7] <= 1.0) {
                                    var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var8 = new double[] {0.875, 0.125, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    }
                } else {
                    var8 = new double[] {0.0, 0.0, 1.0, 0.0};
                }
            }
        } else {
            if (input[0] <= 6.5) {
                if (input[2] <= 8.5) {
                    if (input[3] <= 3.5) {
                        if (input[5] <= 7.5) {
                            if (input[4] <= 5.5) {
                                if (input[1] <= 7.5) {
                                    var8 = new double[] {0.06422018348623854, 0.908256880733945, 0.0, 0.027522935779816515};
                                } else {
                                    var8 = new double[] {0.009375, 0.959375, 0.0, 0.03125};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var8 = new double[] {0.0, 0.8461538461538461, 0.0, 0.15384615384615385};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            if (input[2] <= 6.5) {
                                if (input[6] <= 0.5) {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var8 = new double[] {0.02702702702702703, 0.8108108108108109, 0.0, 0.16216216216216217};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var8 = new double[] {0.0, 0.7058823529411765, 0.0, 0.29411764705882354};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        if (input[1] <= 7.5) {
                            if (input[5] <= 6.5) {
                                if (input[3] <= 5.5) {
                                    var8 = new double[] {0.058823529411764705, 0.5294117647058824, 0.0, 0.4117647058823529};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var8 = new double[] {0.0, 0.07692307692307693, 0.6923076923076923, 0.23076923076923078};
                                } else {
                                    var8 = new double[] {0.0, 0.028985507246376812, 0.2753623188405797, 0.6956521739130435};
                                }
                            }
                        } else {
                            if (input[5] <= 5.5) {
                                if (input[1] <= 9.5) {
                                    var8 = new double[] {0.0, 0.6785714285714286, 0.0, 0.32142857142857145};
                                } else {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 7.5) {
                                    var8 = new double[] {0.012165450121654502, 0.08029197080291971, 0.0, 0.9075425790754258};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.8461538461538461, 0.15384615384615385};
                                }
                            }
                        }
                    }
                } else {
                    if (input[7] <= 1.5) {
                        if (input[1] <= 7.5) {
                            if (input[0] <= 5.5) {
                                if (input[5] <= 5.5) {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var8 = new double[] {0.0, 0.6, 0.0, 0.4};
                                }
                            } else {
                                var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[2] <= 9.5) {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.25, 0.625, 0.0, 0.125};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var8 = new double[] {0.0, 0.11538461538461539, 0.0, 0.8846153846153846};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 6.5) {
                            if (input[6] <= 2.5) {
                                if (input[1] <= 7.5) {
                                    var8 = new double[] {0.0, 0.15, 0.0, 0.85};
                                } else {
                                    var8 = new double[] {0.0, 0.024, 0.0, 0.976};
                                }
                            } else {
                                var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[5] <= 9.0) {
                                var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var8 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        }
                    }
                }
            } else {
                if (input[4] <= 3.5) {
                    if (input[5] <= 5.5) {
                        if (input[4] <= 2.5) {
                            if (input[1] <= 9.5) {
                                if (input[0] <= 7.5) {
                                    var8 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.8135593220338984, 0.1864406779661017, 0.0, 0.0};
                                }
                            } else {
                                if (input[7] <= 1.5) {
                                    var8 = new double[] {0.4, 0.6, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 8.5) {
                                if (input[7] <= 0.5) {
                                    var8 = new double[] {0.375, 0.625, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.17391304347826086, 0.8260869565217391, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 1.5) {
                                    var8 = new double[] {0.6, 0.4, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[2] <= 7.5) {
                            if (input[0] <= 7.5) {
                                if (input[5] <= 7.5) {
                                    var8 = new double[] {0.5797101449275363, 0.36231884057971014, 0.0, 0.057971014492753624};
                                } else {
                                    var8 = new double[] {0.88, 0.12, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var8 = new double[] {0.9809523809523809, 0.01904761904761905, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.9186046511627907, 0.06976744186046512, 0.0, 0.011627906976744186};
                                }
                            }
                        } else {
                            if (input[7] <= 1.5) {
                                if (input[1] <= 8.5) {
                                    var8 = new double[] {0.7948717948717948, 0.20512820512820512, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.21052631578947367, 0.5789473684210527, 0.0, 0.21052631578947367};
                                }
                            } else {
                                if (input[3] <= 3.0) {
                                    var8 = new double[] {0.5, 0.5, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[0] <= 7.5) {
                        if (input[4] <= 4.5) {
                            if (input[3] <= 3.5) {
                                if (input[5] <= 6.5) {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.5, 0.375, 0.0, 0.125};
                                }
                            } else {
                                if (input[3] <= 4.5) {
                                    var8 = new double[] {0.3, 0.3, 0.0, 0.4};
                                } else {
                                    var8 = new double[] {0.0, 0.07142857142857142, 0.0, 0.9285714285714286};
                                }
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                if (input[1] <= 9.5) {
                                    var8 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[4] <= 5.5) {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var8 = new double[] {0.0, 0.125, 0.0, 0.875};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 7.5) {
                            if (input[7] <= 0.5) {
                                if (input[6] <= 1.5) {
                                    var8 = new double[] {0.5454545454545454, 0.45454545454545453, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.9130434782608695, 0.08695652173913043, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var8 = new double[] {0.8571428571428571, 0.14285714285714285, 0.0, 0.0};
                                } else {
                                    var8 = new double[] {0.125, 0.8125, 0.0, 0.0625};
                                }
                            }
                        } else {
                            if (input[3] <= 3.5) {
                                var8 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[2] <= 7.5) {
                                    var8 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var8 = new double[] {0.16666666666666666, 0.0, 0.0, 0.8333333333333334};
                                }
                            }
                        }
                    }
                }
            }
        }
        double[] var9;
        if (input[0] <= 6.5) {
            if (input[1] <= 6.5) {
                if (input[5] <= 6.5) {
                    if (input[3] <= 6.5) {
                        if (input[6] <= 2.5) {
                            if (input[4] <= 5.5) {
                                if (input[7] <= 1.5) {
                                    var9 = new double[] {0.21212121212121213, 0.7878787878787878, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.0, 0.6363636363636364, 0.0, 0.36363636363636365};
                                }
                            } else {
                                var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[3] <= 2.5) {
                                var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                } else {
                    if (input[3] <= 5.5) {
                        if (input[0] <= 5.5) {
                            if (input[2] <= 6.5) {
                                if (input[4] <= 2.0) {
                                    var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var9 = new double[] {0.0, 0.7142857142857143, 0.0, 0.2857142857142857};
                                }
                            } else {
                                var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        } else {
                            if (input[3] <= 1.5) {
                                var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[7] <= 0.5) {
                                    var9 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 6.5) {
                            if (input[1] <= 5.5) {
                                var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[5] <= 7.5) {
                                    var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        } else {
                            var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                }
            } else {
                if (input[3] <= 3.5) {
                    if (input[4] <= 4.5) {
                        if (input[7] <= 1.5) {
                            if (input[6] <= 2.5) {
                                if (input[3] <= 2.5) {
                                    var9 = new double[] {0.01020408163265306, 0.9897959183673469, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.024096385542168676, 0.9216867469879518, 0.0, 0.05421686746987952};
                                }
                            } else {
                                if (input[2] <= 5.5) {
                                    var9 = new double[] {0.5555555555555556, 0.4444444444444444, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.11428571428571428, 0.8857142857142857, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 3.5) {
                                if (input[6] <= 0.5) {
                                    var9 = new double[] {0.0, 0.18181818181818182, 0.0, 0.8181818181818182};
                                } else {
                                    var9 = new double[] {0.03389830508474576, 0.847457627118644, 0.0, 0.11864406779661017};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var9 = new double[] {0.0, 0.6875, 0.0, 0.3125};
                                } else {
                                    var9 = new double[] {0.0, 0.28125, 0.0, 0.71875};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 6.5) {
                            if (input[7] <= 1.5) {
                                var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                if (input[2] <= 5.5) {
                                    var9 = new double[] {0.0, 0.4, 0.0, 0.6};
                                } else {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[0] <= 5.5) {
                                if (input[7] <= 1.5) {
                                    var9 = new double[] {0.0, 0.3181818181818182, 0.0, 0.6818181818181818};
                                } else {
                                    var9 = new double[] {0.0, 0.03225806451612903, 0.0, 0.967741935483871};
                                }
                            } else {
                                if (input[5] <= 8.5) {
                                    var9 = new double[] {0.0, 0.9166666666666666, 0.0, 0.08333333333333333};
                                } else {
                                    var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    }
                } else {
                    if (input[7] <= 0.5) {
                        if (input[0] <= 4.5) {
                            if (input[3] <= 7.5) {
                                if (input[0] <= 3.5) {
                                    var9 = new double[] {0.0, 0.0, 0.07692307692307693, 0.9230769230769231};
                                } else {
                                    var9 = new double[] {0.0, 0.17142857142857143, 0.0, 0.8285714285714286};
                                }
                            } else {
                                var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[2] <= 7.5) {
                                if (input[4] <= 4.5) {
                                    var9 = new double[] {0.15625, 0.75, 0.0, 0.09375};
                                } else {
                                    var9 = new double[] {0.0, 0.09090909090909091, 0.0, 0.9090909090909091};
                                }
                            } else {
                                if (input[6] <= 2.5) {
                                    var9 = new double[] {0.0, 0.2, 0.0, 0.8};
                                } else {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[4] <= 6.5) {
                            if (input[3] <= 4.5) {
                                if (input[5] <= 6.5) {
                                    var9 = new double[] {0.015151515151515152, 0.5606060606060606, 0.0, 0.42424242424242425};
                                } else {
                                    var9 = new double[] {0.0, 0.06993006993006994, 0.0, 0.9300699300699301};
                                }
                            } else {
                                if (input[5] <= 4.5) {
                                    var9 = new double[] {0.0, 0.3333333333333333, 0.0, 0.6666666666666666};
                                } else {
                                    var9 = new double[] {0.0, 0.0, 0.002421307506053269, 0.9975786924939467};
                                }
                            }
                        } else {
                            if (input[5] <= 7.5) {
                                if (input[7] <= 1.5) {
                                    var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                                } else {
                                    var9 = new double[] {0.0, 0.0, 0.2857142857142857, 0.7142857142857143};
                                }
                            } else {
                                if (input[3] <= 6.5) {
                                    var9 = new double[] {0.0, 0.0, 0.1, 0.9};
                                } else {
                                    var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[4] <= 3.5) {
                if (input[8] <= 1.5) {
                    if (input[5] <= 5.5) {
                        if (input[6] <= 0.5) {
                            var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                        } else {
                            if (input[1] <= 6.5) {
                                if (input[8] <= 0.5) {
                                    var9 = new double[] {0.7, 0.3, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 8.5) {
                                    var9 = new double[] {0.2571428571428571, 0.7428571428571429, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[7] <= 1.5) {
                            if (input[1] <= 6.5) {
                                if (input[2] <= 4.5) {
                                    var9 = new double[] {0.8235294117647058, 0.17647058823529413, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.9529411764705882, 0.047058823529411764, 0.0, 0.0};
                                }
                            } else {
                                if (input[8] <= 0.5) {
                                    var9 = new double[] {0.5454545454545454, 0.42424242424242425, 0.0, 0.030303030303030304};
                                } else {
                                    var9 = new double[] {0.7747747747747747, 0.21621621621621623, 0.0, 0.009009009009009009};
                                }
                            }
                        } else {
                            if (input[3] <= 5.5) {
                                if (input[2] <= 5.5) {
                                    var9 = new double[] {0.7000000000000001, 0.20000000000000004, 0.0, 0.10000000000000002};
                                } else {
                                    var9 = new double[] {0.4583333333333333, 0.041666666666666664, 0.0, 0.5};
                                }
                            } else {
                                var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                } else {
                    if (input[1] <= 8.5) {
                        if (input[1] <= 7.5) {
                            if (input[5] <= 4.5) {
                                if (input[4] <= 1.5) {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var9 = new double[] {0.9444444444444444, 0.0, 0.0, 0.05555555555555555};
                                } else {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 2.5) {
                                if (input[2] <= 9.5) {
                                    var9 = new double[] {0.76, 0.24, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    } else {
                        if (input[1] <= 9.5) {
                            if (input[0] <= 7.5) {
                                if (input[3] <= 3.5) {
                                    var9 = new double[] {0.1111111111111111, 0.8888888888888888, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.75, 0.25, 0.0, 0.0};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.9285714285714286, 0.07142857142857142, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[4] <= 2.5) {
                                var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                            } else {
                                var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    }
                }
            } else {
                if (input[1] <= 7.5) {
                    if (input[4] <= 7.5) {
                        if (input[5] <= 4.5) {
                            if (input[1] <= 6.5) {
                                var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                if (input[0] <= 8.5) {
                                    var9 = new double[] {0.07692307692307693, 0.9230769230769231, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.6666666666666666, 0.3333333333333333, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[2] <= 6.5) {
                                if (input[3] <= 2.5) {
                                    var9 = new double[] {0.8125, 0.1875, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.9705882352941176, 0.029411764705882353, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 7.5) {
                                    var9 = new double[] {0.7111111111111111, 0.24444444444444444, 0.0, 0.044444444444444446};
                                } else {
                                    var9 = new double[] {0.36363636363636365, 0.09090909090909091, 0.09090909090909091, 0.45454545454545453};
                                }
                            }
                        }
                    } else {
                        if (input[5] <= 7.5) {
                            var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                        } else {
                            var9 = new double[] {0.0, 0.0, 1.0, 0.0};
                        }
                    }
                } else {
                    if (input[7] <= 1.5) {
                        if (input[6] <= 1.5) {
                            if (input[2] <= 7.5) {
                                if (input[3] <= 3.5) {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.16666666666666666, 0.8333333333333334, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 4.5) {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.0, 0.25, 0.0, 0.75};
                                }
                            }
                        } else {
                            if (input[8] <= 1.5) {
                                if (input[7] <= 0.5) {
                                    var9 = new double[] {0.3125, 0.6875, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 4.5) {
                                    var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            if (input[2] <= 7.5) {
                                if (input[4] <= 6.5) {
                                    var9 = new double[] {0.0, 0.8571428571428571, 0.0, 0.14285714285714285};
                                } else {
                                    var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                var9 = new double[] {0.0, 1.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                var9 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var9 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        }
                    }
                }
            }
        }
        double[] var10;
        if (input[3] <= 6.5) {
            if (input[0] <= 6.5) {
                if (input[7] <= 1.5) {
                    if (input[3] <= 4.5) {
                        if (input[6] <= 0.5) {
                            if (input[1] <= 8.5) {
                                if (input[5] <= 6.5) {
                                    var10 = new double[] {0.0, 0.92, 0.0, 0.08};
                                } else {
                                    var10 = new double[] {0.15384615384615385, 0.5384615384615384, 0.0, 0.3076923076923077};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var10 = new double[] {0.0, 0.7142857142857143, 0.0, 0.2857142857142857};
                                } else {
                                    var10 = new double[] {0.0, 0.1, 0.0, 0.9};
                                }
                            }
                        } else {
                            if (input[5] <= 7.5) {
                                if (input[3] <= 3.5) {
                                    var10 = new double[] {0.043373493975903614, 0.9421686746987952, 0.0, 0.014457831325301205};
                                } else {
                                    var10 = new double[] {0.12121212121212122, 0.7272727272727273, 0.0, 0.15151515151515152};
                                }
                            } else {
                                if (input[3] <= 2.5) {
                                    var10 = new double[] {0.043478260869565216, 0.9565217391304348, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.07894736842105263, 0.3157894736842105, 0.0, 0.6052631578947368};
                                }
                            }
                        }
                    } else {
                        if (input[6] <= 2.5) {
                            if (input[2] <= 3.5) {
                                var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[5] <= 4.5) {
                                    var10 = new double[] {0.0, 0.6, 0.0, 0.4};
                                } else {
                                    var10 = new double[] {0.007936507936507936, 0.015873015873015872, 0.023809523809523808, 0.9523809523809523};
                                }
                            }
                        } else {
                            var10 = new double[] {0.0, 1.0, 0.0, 0.0};
                        }
                    }
                } else {
                    if (input[1] <= 5.5) {
                        var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                    } else {
                        if (input[5] <= 6.5) {
                            if (input[8] <= 0.5) {
                                if (input[0] <= 5.5) {
                                    var10 = new double[] {0.0, 0.13157894736842105, 0.0, 0.868421052631579};
                                } else {
                                    var10 = new double[] {0.0, 0.5882352941176471, 0.0, 0.4117647058823529};
                                }
                            } else {
                                if (input[5] <= 5.5) {
                                    var10 = new double[] {0.0, 0.6774193548387096, 0.0, 0.3225806451612903};
                                } else {
                                    var10 = new double[] {0.0, 0.34146341463414637, 0.0, 0.6585365853658537};
                                }
                            }
                        } else {
                            if (input[2] <= 2.5) {
                                if (input[4] <= 6.0) {
                                    var10 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 7.5) {
                                    var10 = new double[] {0.014084507042253521, 0.11267605633802817, 0.0, 0.8732394366197183};
                                } else {
                                    var10 = new double[] {0.0, 0.036211699164345405, 0.0, 0.9637883008356546};
                                }
                            }
                        }
                    }
                }
            } else {
                if (input[4] <= 3.5) {
                    if (input[0] <= 8.5) {
                        if (input[4] <= 2.5) {
                            if (input[3] <= 4.5) {
                                if (input[5] <= 5.5) {
                                    var10 = new double[] {0.6625, 0.3375, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.9086294416243654, 0.07614213197969544, 0.0, 0.015228426395939087};
                                }
                            } else {
                                if (input[0] <= 7.5) {
                                    var10 = new double[] {0.2857142857142857, 0.0, 0.0, 0.7142857142857143};
                                } else {
                                    var10 = new double[] {0.8888888888888888, 0.1111111111111111, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[6] <= 1.5) {
                                if (input[0] <= 7.5) {
                                    var10 = new double[] {0.11538461538461539, 0.6538461538461539, 0.0, 0.23076923076923078};
                                } else {
                                    var10 = new double[] {0.6764705882352942, 0.3235294117647059, 0.0, 0.0};
                                }
                            } else {
                                if (input[5] <= 5.5) {
                                    var10 = new double[] {0.5365853658536586, 0.4634146341463415, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.8211382113821138, 0.16260162601626016, 0.0, 0.016260162601626018};
                                }
                            }
                        }
                    } else {
                        if (input[2] <= 6.5) {
                            if (input[7] <= 0.5) {
                                if (input[5] <= 7.5) {
                                    var10 = new double[] {1.0, 0.0, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.9629629629629629, 0.037037037037037035, 0.0, 0.0};
                                }
                            } else {
                                if (input[1] <= 8.5) {
                                    var10 = new double[] {0.9803921568627451, 0.0196078431372549, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.5555555555555556, 0.3333333333333333, 0.0, 0.1111111111111111};
                                }
                            }
                        } else {
                            var10 = new double[] {1.0, 0.0, 0.0, 0.0};
                        }
                    }
                } else {
                    if (input[1] <= 7.5) {
                        if (input[3] <= 5.5) {
                            if (input[6] <= 1.5) {
                                if (input[5] <= 4.5) {
                                    var10 = new double[] {0.0, 1.0, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.7647058823529411, 0.17647058823529413, 0.0, 0.058823529411764705};
                                }
                            } else {
                                if (input[3] <= 3.5) {
                                    var10 = new double[] {0.8035714285714286, 0.19642857142857142, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {1.0, 0.0, 0.0, 0.0};
                                }
                            }
                        } else {
                            if (input[7] <= 1.0) {
                                var10 = new double[] {1.0, 0.0, 0.0, 0.0};
                            } else {
                                var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                            }
                        }
                    } else {
                        if (input[3] <= 3.5) {
                            if (input[6] <= 2.5) {
                                if (input[5] <= 7.5) {
                                    var10 = new double[] {0.05555555555555555, 0.9444444444444444, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.2, 0.6, 0.0, 0.2};
                                }
                            } else {
                                var10 = new double[] {1.0, 0.0, 0.0, 0.0};
                            }
                        } else {
                            if (input[2] <= 6.5) {
                                if (input[7] <= 1.5) {
                                    var10 = new double[] {0.3333333333333333, 0.6666666666666666, 0.0, 0.0};
                                } else {
                                    var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            } else {
                                if (input[4] <= 5.5) {
                                    var10 = new double[] {0.0, 0.05, 0.0, 0.95};
                                } else {
                                    var10 = new double[] {0.0, 0.2, 0.0, 0.8};
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (input[1] <= 7.5) {
                if (input[4] <= 4.0) {
                    var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                } else {
                    if (input[4] <= 5.5) {
                        if (input[3] <= 7.5) {
                            if (input[8] <= 0.5) {
                                var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                            } else {
                                var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                            }
                        } else {
                            if (input[2] <= 6.5) {
                                var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                            } else {
                                if (input[1] <= 6.0) {
                                    var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                                } else {
                                    var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                                }
                            }
                        }
                    } else {
                        var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            } else {
                if (input[4] <= 5.5) {
                    var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                } else {
                    if (input[5] <= 9.5) {
                        var10 = new double[] {0.0, 0.0, 0.0, 1.0};
                    } else {
                        var10 = new double[] {0.0, 0.0, 1.0, 0.0};
                    }
                }
            }
        }
        return addVectors(addVectors(addVectors(addVectors(addVectors(addVectors(addVectors(addVectors(addVectors(addVectors(var0, var1), var2), var3), var4), var5), var6), var7), var8), var9), var10);
    }
    private static double[] addVectors(double[] v1, double[] v2) {
        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] + v2[i];
        }
        return result;
    }
    private static double[] mulVectorNumber(double[] v1, double num) {
        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] * num;
        }
        return result;
    }
}