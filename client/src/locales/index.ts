import i18n from 'i18next';
import {initReactI18next} from 'react-i18next';
import {addPersonLangEN, addPersonLangRU, addPersonLangDE} from "../pages/addPerson/languages";
import {menuLangDE, menuLangEN, menuLangRU,} from "../pages/menuPage/languages";
import {addVehLangDE, addVehLangEN, addVehLangRU} from "../pages/addVehicle/languge";
import {getPersonsLangDE, getPersonsLangEN, getPersonsLangRU} from "../pages/personListPage/language";
import {
    tablePersonLangDE,
    tablePersonLangEN,
    tablePersonLangRU
} from "../components/UI/Table/LightTablePersons/language";
import {tableVehLangDE, tableVehLangEN, tableVehLangRU} from "../components/UI/Table/LightTableVehicles/language";
import {getVehLangDE, getVehLangEN, getVehLangRU} from "../pages/vehicleListPage/language";

// Языковые ресурсы
const resources = {
    en: {
        translation: {
            cancel: 'Cancel',
            fillAll: 'Fill in all fields',
            chooseBirthday: 'Choose birthday',
            ...addPersonLangEN,
            ...menuLangEN,
            ...addVehLangEN,
            ...getPersonsLangEN,
            back: 'Back',
            ...tablePersonLangEN,
            ...tableVehLangEN,
            ...getVehLangEN
        },
    },
    ru: {
        translation: {
            cancel: 'Отменить',
            fillAll: 'Заполните все поля',
            chooseBirthday: 'Выберете дату рождения',
            ...addPersonLangRU,
            ...menuLangRU,
            ...getPersonsLangRU,
            back: 'Назад',
            ...tablePersonLangRU,
            ...tableVehLangRU,
            ...getVehLangRU
        },
    },
    de: {
        translation: {
            cancel: 'Abschaffung von',
            fillAll: 'Füllen Sie alle Felder aus',
            chooseBirthday: 'Geburtstag wählen',
            ...addPersonLangDE,
            ...menuLangDE,
            ...addVehLangDE,
            ...getPersonsLangDE,
            back: 'Zurück',
            ...tablePersonLangDE,
            ...tableVehLangDE,
            ...getVehLangDE
        },
    },
};

i18n
    .use(initReactI18next) // Инициализация react-i18next
    .init({
        resources,
        lng: 'en', // Начальный язык по умолчанию
        fallbackLng: 'en', // Язык по умолчанию в случае отсутствия перевода
        interpolation: {
            escapeValue: false, // Не экранировать HTML и прочее в переводах
        },
        react: {
            useSuspense: false, // Отключение использования Suspense (можно включить для React 18+)
        },
    });

export default i18n;