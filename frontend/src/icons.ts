import { library } from "@fortawesome/fontawesome-svg-core";
import { faLocationDot, faPlus, faMinus } from "@fortawesome/free-solid-svg-icons";
import { faMap, faCalendar, faCircleUser } from "@fortawesome/free-regular-svg-icons";

library.add(
  faLocationDot,
  faMap,
  faCalendar,
  faCircleUser,
  faPlus,
  faMinus,
);

export const ICON_NAMES = {
  map: faMap,
  location: faLocationDot,
  calendar: faCalendar,
  user: faCircleUser,
  plus: faPlus,
  minus: faMinus,
};
