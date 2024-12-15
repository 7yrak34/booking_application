import { DateCalendar, LocalizationProvider } from '@mui/x-date-pickers';
import { Dropdown } from '../Dropdown';
import './BookingForm.scss';
import dayjs from 'dayjs';
import { Counter } from '../Counter';
import { useMemo, useState } from 'react';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { ICON_NAMES } from '../../icons';

const cities = ['Odessa', 'Kiev', 'Kharkiv', 'Lviv', 'Dnepr'];
const minRooms = 1;
const minAdults = 1;
const minChildren = 0;

function createGuestsRequestTitle(
  adultsQuantity: number,
  childrenQuantity: number,
  roomsQuantity: number
) {
  const pluralize = (quantity: number, singular: string, plural: string) => (
    `${quantity} ${quantity === 1 ? singular : plural}`
  );

  const adults = pluralize(adultsQuantity, 'adult', 'adults');
  const children = childrenQuantity
    ? `, ${pluralize(childrenQuantity, 'child', 'children')}`
    : '';

  const rooms = ` - ${pluralize(roomsQuantity, 'room', 'rooms')}`;

  return adults + children + rooms;
}

export const BookingForm = () => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState<string | null>(null);

  const [isStartCalendarShown, setIsStartCalendarShown] = useState(false);
  const [startDate, setStartDate] = useState<Date | null>(null);

  const [isEndCalendarShown, setIsEndCalendarShown] = useState(false);
  const [endDate, setEndDate] = useState<Date | null>(null);

  const [isGuestsShown, setIsGuestsShown] = useState(false);
  const [roomsCount, setRoomsCount] = useState(minRooms);
  const [adultsCount, setAdultsCount] = useState(minAdults);
  const [childrenCount, setChildrenCount] = useState(minChildren);

  const counters = useMemo(() => {
    return [
      {
        title: 'Rooms',
        count: roomsCount,
        increase: () => setRoomsCount(roomsCount + 1),
        decrease: () => {
          if (roomsCount > minRooms) {
            setRoomsCount(roomsCount - 1);
          }
        },
      }, {
        title: 'Adults',
        count: adultsCount,
        increase: () => setAdultsCount(adultsCount + 1),
        decrease: () => {
          if (adultsCount > minAdults) {
            setAdultsCount(adultsCount - 1);
          }
        },
      }, {
        title: 'Children',
        count: childrenCount,
        increase: () => setChildrenCount(childrenCount + 1),
        decrease: () => {
          if (childrenCount > minChildren) {
            setChildrenCount(childrenCount - 1);
          }
        },
      },
    ];
  }, [roomsCount, childrenCount, adultsCount, minRooms, minAdults, minChildren]);

  const guestsDropdownTitle = useMemo(() => {
    return createGuestsRequestTitle(adultsCount, childrenCount, roomsCount);
  }, [adultsCount, childrenCount, roomsCount]);

  return (
    <div className="booking-form">
      <Dropdown
        title={selectedOption ? selectedOption : 'City'}
        icon={ICON_NAMES.map}
        isOpen={isDropdownOpen}
        setIsOpen={setIsDropdownOpen}
      >
        <ul className="booking-form__list">
          {cities.map(city => (
            <li
              key={city}
              className="booking-form__option booking-form__option--pointer"
              onClick={() => {
                setSelectedOption(city);
                setIsDropdownOpen(false);
              }}
            >
              {city}
            </li>
          ))}
        </ul>
      </Dropdown>

      <Dropdown
        title={startDate ? dayjs(startDate).format('dddd, DD MMMM YYYY') : 'Check in'}
        icon={ICON_NAMES.calendar}
        isOpen={isStartCalendarShown}
        setIsOpen={setIsStartCalendarShown}
      >
        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DateCalendar
            sx={{ width: "100%" }}
            minDate={dayjs()}
            maxDate={dayjs().add(1, 'year')}
            onChange={date => {
              setStartDate(date);
              setIsStartCalendarShown(false);
            }}
          />
        </LocalizationProvider>
      </Dropdown>

      <Dropdown
        title={endDate ? dayjs(endDate).format('dddd, DD MMMM YYYY') : 'Check out'}
        icon={ICON_NAMES.calendar}
        isOpen={isEndCalendarShown}
        setIsOpen={setIsEndCalendarShown}
      >
        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DateCalendar
            sx={{ width: "100%" }}
            minDate={startDate ? dayjs(startDate).add(1, 'day') : dayjs().add(1, 'day')}
            maxDate={dayjs().add(1, 'year')}
            onChange={date => {
              setEndDate(date);
              setIsEndCalendarShown(false);
            }}
          />
        </LocalizationProvider>
      </Dropdown>

      <Dropdown
        title={guestsDropdownTitle}
        icon={ICON_NAMES.user}
        isOpen={isGuestsShown}
        setIsOpen={setIsGuestsShown}
      >
        <ul className="booking-form__list">
          {counters.map(({ title, count, increase, decrease }) => (
            <li key={title} className="booking-form__option">
              {title}

              <Counter
                count={count}
                increaseCount={increase}
                decreaseCount={decrease}
              />
            </li>
          ))}
        </ul>
      </Dropdown>

      <button className="booking-form__confirm-button">
        Search
      </button>
    </div>
  );
};
