public class Main {

        // Определение, сколько дней еще продержатся запасы
        public int howMuchDays(int[] supplies, int consumptionPerDay) {
            // Рассчитываем оставшееся количество дней
            int totalSupplies = 0;
            for (int supply : supplies) {
                totalSupplies += supply;
            }
            return totalSupplies / consumptionPerDay;
        }

        // Проверка состояния запасов
        public String checkSupplies(int[] supplies) {
            // Проверяем наличие запасов
            boolean isEmpty = true;
            for (int supply : supplies) {
                if (supply > 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                return "Запасы исчерпаны";
            } else {
                return "Запасы еще есть";
            }
        }

        // Пополнение запасов
        public void restockSupplies(int[] supplies, int[] restockAmounts) {
            // Пополняем запасы
            for (int i = 0; i < supplies.length && i < restockAmounts.length; i++) {
                supplies[i] += restockAmounts[i];
            }
        }



    // Статическая функция для генерации случайного расположения бункера
    public static int[][] generateRandomBunker(int rows, int cols) {
        int[][] bunkerLayout = new int[rows][cols];
        // Заполняем бункер псевдослучайным образом
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Простой способ генерации: чередование 1 и 0 по рядам
                bunkerLayout[i][j] = (i + j) % 2;
            }
        }
        return bunkerLayout;
    }

    // Статическая функция для реконструкции бункера (полное восстановление стен)
    public static void reconstructBunker(int[][] bunkerLayout) {
        // Проходим по всем ячейкам бункера и восстанавливаем стены (ставим 1)
        for (int i = 0; i < bunkerLayout.length; i++) {
            for (int j = 0; j < bunkerLayout[0].length; j++) {
                bunkerLayout[i][j] = 1;
            }
        }
    }

    // Функция для проверки состояния бункера и возвращения сообщения о его состоянии
    public static String checkBunkerStatus(int[][] bunkerLayout) {
        boolean isIntact = isBunkerIntact(bunkerLayout);
        if (isIntact) {
            return "Бункер не поврежден";
        } else {
            return "Бункер поврежден";
        }
    }



    // Вспомогательная функция для проверки целостности бункера
    private static boolean isBunkerIntact(int[][] bunkerLayout) {
        // Проходим по всем ячейкам бункера
        for (int i = 0; i < bunkerLayout.length; i++) {
            for (int j = 0; j < bunkerLayout[0].length; j++) {
                // Если хотя бы одна стена разрушена (значение 0), бункер считается поврежденным
                if (bunkerLayout[i][j] == 0) {
                    return false;
                }
            }
        }
        // Если не найдено разрушенных стен, бункер цел
        return true;
    }
    // Статическая функция для генерации тестового расположения
    public static int[][] generateTestLayout(int rows, int cols) {
        int[][] layout = new int[rows][cols];
        // Пример тестового расположения (1 - стена цела, 0 - стена разрушена)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                layout[i][j] = (i + j) % 2; // Простой пример распределения для тестирования
            }
        }
        return layout;
    }

    // Статическая функция для реконструкции расположения (полное восстановление стен)
    public static void reconstructLayout(int[][] layout) {
        // Проходим по всем ячейкам и восстанавливаем стены (ставим 1)
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                layout[i][j] = 1;
            }
        }
    }



    // Вспомогательная функция для вывода расположения на экран
    public static void printLayout(int[][] layout) {
        for (int[] row : layout) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    // Функция для проверки, является ли расположение целым (без повреждений)
    public static boolean isLayoutIntact(int[][] layout) {
        // Проходим по всем ячейкам расположения
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                // Если нашли разрушенную ячейку (значение 0), возвращаем false
                if (layout[i][j] == 0) {
                    return false;
                }
            }
        }
        // Если не найдено разрушенных ячеек, возвращаем true (расположение целое)
        return true;
    }



    // Функция для проверки состояния расположения и возвращения сообщения о его состоянии
    public String checkLayoutStatus(int[][] layout) {
        boolean isIntact = isLayoutIntact(layout);
        if (isIntact) {
            return "Расположение не повреждено";
        } else {
            return "Расположение повреждено";
        }
    }

    // Функция для подсчета количества погибших элементов в расположении




    public static void main(String[] args) {
        // Пример использования функций

        // Генерируем случайное расположение бункера 5x5
        int[][] bunkerLayout = generateRandomBunker(5, 5);

        // Проверяем состояние бункера
        System.out.println("Состояние бункера: " + checkBunkerStatus(bunkerLayout));

        // Восстанавливаем бункер
        reconstructBunker(bunkerLayout);

        // Снова проверяем состояние бункера после реконструкции
        System.out.println("Состояние бункера после реконструкции: " + checkBunkerStatus(bunkerLayout));



            // Пример данных о запасах
            int[] supplies = {100, 50, 75}; // Пример запасов: еда, вода, медикаменты
            int consumptionPerDay = 10; // Расход за день

            // Создаем объект класса Main
            Main main = new Main();

            // Вызов функции для определения, сколько дней еще продержатся запасы
            int remainingDays = main.howMuchDays(supplies, consumptionPerDay);
            System.out.println("Запасы продержатся еще " + remainingDays + " дней");

            // Вызов функции для проверки состояния запасов
            String suppliesStatus = main.checkSupplies(supplies);
            System.out.println("Состояние запасов: " + suppliesStatus);

            // Пример данных о пополнении запасов
            int[] restockAmounts = {20, 30, 10}; // Пример пополнения: еда, вода, медикаменты

            // Вызов функции для пополнения запасов
            main.restockSupplies(supplies, restockAmounts);

            // Повторно вызываем функцию для проверки состояния запасов
            suppliesStatus = main.checkSupplies(supplies);
            System.out.println("Состояние запасов после пополнения: " + suppliesStatus);

        // Пример тестового расположения
        int[][] testLayout = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};






    }


}