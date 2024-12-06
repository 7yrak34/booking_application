import React from "react";
import { IconType } from "../../types/IconType";
import './Icon.scss';
import classNames from "classnames";
import { IconColor } from "../../types/IconColor";

interface Props {
  iconType: IconType,
  color?: IconColor | string,
  width?: number,
  height?: number,
  isActive?: boolean,
}

export const Icon: React.FC<Props> = ({ 
  iconType,
  width = 24,
  height = 24,
  isActive = false,
  color = IconColor.whiteColor,
}) => {
  switch (iconType) {
    case IconType.logo:
      return (
        <svg width={width} height={height} viewBox="0 0 101 53" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M5.46958 37.6149H5.00995L0 42.9931V43.6984H1.70062V48.6357C1.70062 51.8538 3.86088 52.9559 6.34287 52.9559C7.49195 52.9559 8.50313 52.7355 9.83606 52.2506V49.6497C8.87084 50.1346 8.13542 50.3109 7.40001 50.3109C6.34287 50.3109 5.46958 49.4733 5.46958 48.4594V43.7425H9.83606V41.2738H5.46958V37.6149ZM15.7193 44.536H15.6733V41.2297H11.9044V52.6914H15.6733V47.7541C16.5007 45.6381 17.374 44.4037 18.7529 44.4037C19.3504 44.4037 19.9939 44.6682 21.0051 45.2413L22.0622 42.0673C20.9591 41.2738 20.3156 41.0093 19.5802 41.0093C18.0634 41.0093 16.8224 42.1555 15.7193 44.536ZM33.5989 49.7378V44.4919C33.5989 41.9792 31.5305 41.0093 28.5429 41.0093C26.6585 41.0093 24.9119 41.4942 23.3491 42.42V45.3736C24.5442 44.1833 26.2448 43.4339 27.7616 43.4339C29.4162 43.4339 29.9218 44.2715 29.8299 45.3736C24.8199 46.8724 22.7057 47.4014 22.7057 50.1346C22.7057 51.5893 24.1305 52.9559 26.061 52.9559C27.3479 52.9559 28.543 52.6032 30.0138 51.6775C30.2895 52.6032 30.887 52.9559 32.128 52.9559C33.1392 52.9559 34.6101 52.5151 35.6672 51.8979V49.8701C34.7939 50.4872 34.5181 50.5313 34.2424 50.5313C33.8287 50.5313 33.5989 50.3109 33.5989 49.7378ZM29.8299 49.9582C29.1864 50.4872 28.451 50.8399 27.7616 50.8399C27.0721 50.8399 26.5206 50.3109 26.5206 49.6056C26.5206 48.4594 27.5777 47.9745 29.8299 47.181V49.9582ZM41.9641 47.5778L39.4362 41.2738H35.3914L40.907 53H43.0213L48.5368 41.2738H44.538L41.9641 47.5778ZM75.517 37.6149H75.0574L70.0474 42.9931V43.6984H71.7481V48.6357C71.7481 51.8538 73.9083 52.9559 76.3903 52.9559C77.5394 52.9559 78.5506 52.7355 79.8835 52.2506V49.6497C78.9183 50.1346 78.1829 50.3109 77.4475 50.3109C76.3903 50.3109 75.517 49.4733 75.517 48.4594V43.7425H79.8835V41.2738H75.517V37.6149ZM55.6151 41.0093C51.9381 41.0093 49.3182 43.5221 49.3182 47.0047C49.3182 50.5754 52.03 52.9118 56.2586 52.9118C57.1778 52.9118 59.43 52.9118 61.5903 51.413V49.1647C59.8437 50.3991 58.6487 50.7958 57.1319 50.7958C54.7878 50.7958 53.317 49.6056 53.1791 47.5778H61.7741C62.0039 43.3898 59.1083 41.0093 55.6151 41.0093ZM53.317 45.6822C53.4548 44.0952 54.4201 43.1694 55.8909 43.1694C57.3617 43.1694 58.3269 44.0952 58.4648 45.6822H53.317ZM88.0189 41.0093C84.4798 41.0093 81.2624 43.0372 81.2624 46.9606C81.2624 50.5754 84.1121 52.9559 88.0189 52.9559C90.6848 52.9559 94.7295 51.5452 94.7295 47.0047C94.7295 42.5963 90.9606 41.0093 88.0189 41.0093ZM88.0189 50.7958C86.5941 50.7958 85.2612 49.9142 85.2612 46.9606C85.2612 44.3597 86.3643 43.1694 88.0189 43.1694C89.9034 43.1694 90.7308 44.6683 90.7308 46.9165C90.7308 49.4293 89.7655 50.7958 88.0189 50.7958ZM64.3481 52.7355H68.117V35.7634H64.3481V52.7355ZM99.0041 6.35982C97.2115 3.58257 94.4997 2.08373 90.8687 0.805313L90.5009 0.717141C90.409 0.673057 90.3171 0.673059 90.2711 0.628975L89.8115 0.496724L89.3059 0.364479C85.8127 -0.384938 82.2736 0.0118098 79.3779 1.64289C76.1146 3.49439 73.9083 6.62432 72.9891 10.7682C71.9779 15.3969 74.0003 22.5384 79.4239 31.84L79.6537 32.4572L79.7916 38.4084L81.4463 38.8052L84.4338 33.5592C93.4426 27.8284 99.1879 21.8331 100.429 17.3366C101.532 13.2809 101.026 9.48974 99.0041 6.35982ZM89.4438 0.452645C89.4897 0.452645 89.4898 0.452645 89.5357 0.452645C89.5357 0.452645 89.4897 0.452645 89.4438 0.452645ZM80.2053 36.1602L80.1593 32.5894C79.9754 32.0163 76.2525 20.2901 75.7009 17.6892C75.1034 15.0442 75.2872 12.2229 75.3332 12.2229C75.8847 4.06748 81.0785 1.29023 85.2152 0.54081C72.0238 3.67073 78.2748 20.7751 78.2748 20.7751C78.2748 20.7751 78.3208 12.6637 79.6077 8.2554C80.573 3.62664 84.3419 1.55473 86.6401 0.893478C84.0661 2.03965 81.1705 5.34589 80.8947 13.325C80.7108 18.9236 80.3891 32.1045 80.3891 32.2367C80.9407 32.1486 81.3084 32.1927 81.9518 32.369L80.8947 36.3365L80.2053 36.1602ZM97.7171 17.4688C97.7171 17.4688 96.614 19.8934 94.8674 21.9653C93.1668 23.9491 84.25 33.0743 83.8363 33.4711L81.9059 36.7332L81.2164 36.4247L82.3195 32.4572C82.8711 32.5453 83.2388 32.7657 83.6525 33.0302C84.296 32.0163 89.3519 21.5686 92.1096 16.1022C95.4649 9.35747 94.4997 4.99323 92.891 2.65681C94.5457 4.33198 97.0277 7.81456 95.7407 12.2229C94.8215 16.7194 90.1792 24.0813 90.1792 24.0813C90.1792 24.0813 104.152 12.5315 94.6836 3.36214C97.855 6.00714 100.797 10.5918 97.7171 17.4688Z" fill={color} />
        </svg>
      );

    case IconType.profile:
      return (
        <svg width={width} height={height} viewBox="0 0 31 30" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M15.3342 29.5242C23.4298 29.5242 30.016 22.938 30.016 14.8423C30.016 6.74667 23.4298 0.160522 15.3342 0.160522C7.2385 0.160522 0.652344 6.74667 0.652344 14.8423C0.652344 22.938 7.2385 29.5242 15.3342 29.5242ZM15.3342 27.1575C12.5115 27.1575 9.90939 26.2005 7.83005 24.5973C8.75354 22.5211 10.8392 21.1246 13.1469 21.1246H17.4799C19.7995 21.1246 21.8934 22.529 22.8154 24.6155C20.74 26.208 18.1465 27.1575 15.3342 27.1575ZM11.4908 13.2289C11.4908 11.1096 13.2149 9.38556 15.3342 9.38556C17.4534 9.38556 19.1775 11.1096 19.1775 13.2289C19.1775 15.3481 17.4534 17.0726 15.3342 17.0726C13.2149 17.0726 11.4908 15.3485 11.4908 13.2289ZM15.3342 2.52714C22.125 2.52714 27.6494 8.0515 27.6494 14.8423C27.6494 17.9345 26.501 20.7619 24.6122 22.9269C23.2765 20.5801 20.8309 18.9923 18.0955 18.7833C20.1362 17.7646 21.5441 15.6607 21.5441 13.2289C21.5441 9.80443 18.7582 7.01894 15.3342 7.01894C11.9101 7.01894 9.1242 9.80483 9.1242 13.2289C9.1242 15.6591 10.531 17.7622 12.5696 18.7817C9.83233 18.9785 7.37917 20.5599 6.03721 22.9048C4.1594 20.7425 3.01896 17.9242 3.01896 14.8423C3.01896 8.0515 8.54332 2.52714 15.3342 2.52714Z" fill={color} />
        </svg>
      );

    case IconType.close:
      return (
        <svg width={width} height={height} viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" clip-rule="evenodd" d="M18.5001 18.4999C18.1586 18.8413 17.3415 19.3413 17.0001 18.9999L1.00005 2.99985C0.658577 2.65838 1.15853 1.84159 1.5 1.50012C1.84147 1.15865 2.65858 0.658468 3.00005 0.999938L19.0001 16.9999C19.3415 17.3413 18.8415 18.1584 18.5001 18.4999Z" fill={color} />
          <path fill-rule="evenodd" clip-rule="evenodd" d="M1.50005 18.4999C1.15858 18.1584 0.658577 17.3415 1.00005 17.0001L17.0001 0.999938C17.3415 0.658468 18.1586 1.15838 18.5001 1.49985C18.8415 1.84132 19.3415 2.65838 19.0001 2.99985L3.00005 19.0001C2.65858 19.3415 1.84152 18.8413 1.50005 18.4999Z" fill={color} />
        </svg>
      );

    case IconType.location:
      return (
        <svg width={width} height={height} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M21 10C21 17 12 23 12 23C12 23 3 17 3 10C3 7.61305 3.94821 5.32387 5.63604 3.63604C7.32387 1.94821 9.61305 1 12 1C14.3869 1 16.6761 1.94821 18.364 3.63604C20.0518 5.32387 21 7.61305 21 10Z" stroke="#0098DB" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" fill={color} />
          <path d="M12 13C13.6569 13 15 11.6569 15 10C15 8.34315 13.6569 7 12 7C10.3431 7 9 8.34315 9 10C9 11.6569 10.3431 13 12 13Z" stroke="#0098DB" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" fill={color} />
        </svg>
      );

    case IconType.calendar:
      return (
        <svg width={width} height={height} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M21 10C21 17 12 23 12 23C12 23 3 17 3 10C3 7.61305 3.94821 5.32387 5.63604 3.63604C7.32387 1.94821 9.61305 1 12 1C14.3869 1 16.6761 1.94821 18.364 3.63604C20.0518 5.32387 21 7.61305 21 10Z" stroke="#0098DB" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" fill={color} />
          <path d="M12 13C13.6569 13 15 11.6569 15 10C15 8.34315 13.6569 7 12 7C10.3431 7 9 8.34315 9 10C9 11.6569 10.3431 13 12 13Z" stroke="#0098DB" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" fill={color} />
        </svg>
      );

    case IconType.mail:
      return (
        <svg width={width} height={height} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M23 6.125C23 4.95625 22.055 4 20.9 4H4.1C2.945 4 2 4.95625 2 6.125M23 6.125V18.875C23 20.0438 22.055 21 20.9 21H4.1C2.945 21 2 20.0438 2 18.875V6.125M23 6.125L12.5 13.5625L2 6.125" stroke="#0098DB" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" fill={color} />
        </svg>
      );

    case IconType.add:
      return (
        <svg width={width} height={height} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" clip-rule="evenodd" d="M12.5 21.8333C17.6547 21.8333 21.8333 17.6547 21.8333 12.5C21.8333 7.34534 17.6547 3.16667 12.5 3.16667C7.34534 3.16667 3.16667 7.34534 3.16667 12.5C3.16667 17.6547 7.34534 21.8333 12.5 21.8333ZM12.5 23C18.299 23 23 18.299 23 12.5C23 6.70101 18.299 2 12.5 2C6.70101 2 2 6.70101 2 12.5C2 18.299 6.70101 23 12.5 23Z" fill={color} />
          <path fill-rule="evenodd" clip-rule="evenodd" d="M11.355 11.3355V7H13.6446V11.3304L17.9951 11.3208L18 13.6793L13.6446 13.689V18H11.355V13.6941L7.00494 13.7038L7 11.3452L11.355 11.3355Z" fill={color} />
        </svg>
      );

    case IconType.delete:
      return (
        <svg width={width} height={height} viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M4 6.66669H5.83333H20.5" stroke="#0098DB" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round" fill={color} />
          <path d="M8.58325 6.66667V4.83333C8.58325 4.3471 8.77641 3.88079 9.12022 3.53697C9.46404 3.19315 9.93036 3 10.4166 3H14.0833C14.5695 3 15.0358 3.19315 15.3796 3.53697C15.7234 3.88079 15.9166 4.3471 15.9166 4.83333V6.66667M18.6666 6.66667V19.5C18.6666 19.9862 18.4734 20.4525 18.1296 20.7964C17.7858 21.1402 17.3195 21.3333 16.8333 21.3333H7.66659C7.18036 21.3333 6.71404 21.1402 6.37022 20.7964C6.02641 20.4525 5.83325 19.9862 5.83325 19.5V6.66667H18.6666Z" stroke="#0098DB" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round" fill={color} />
          <path d="M10.4167 11.25V16.75" stroke="#0098DB" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round" fill={color} />
          <path d="M14.0833 11.25V16.75" stroke="#0098DB" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round" fill={color} />
        </svg>
      );

    case IconType.heart:
      return (
        <svg width={width} height={height} viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M18.3961 4.93277L18.3964 4.9331C18.7719 5.30843 19.0698 5.75406 19.273 6.24454C19.4763 6.73503 19.5809 7.26074 19.5809 7.79166C19.5809 8.32258 19.4763 8.8483 19.273 9.33878C19.0698 9.82926 18.7719 10.2749 18.3964 10.6502L18.3963 10.6504L17.4246 11.6221L11 18.0466L4.57547 11.6221L3.6038 10.6504C2.84562 9.89221 2.41968 8.86389 2.41968 7.79166C2.41968 6.71943 2.84562 5.69112 3.6038 4.93294C4.36198 4.17475 5.3903 3.74881 6.46253 3.74881C7.53476 3.74881 8.56307 4.17475 9.32125 4.93293L10.2929 5.9046C10.6834 6.29513 11.3166 6.29513 11.7071 5.9046L12.6788 4.93294L12.679 4.93277C13.0543 4.55726 13.4999 4.25939 13.9904 4.05616C14.4809 3.85293 15.0066 3.74832 15.5375 3.74832C16.0684 3.74832 16.5942 3.85293 17.0846 4.05616C17.5751 4.25939 18.0208 4.55726 18.3961 4.93277Z" fill={color} stroke="#FF6847" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      );

    case IconType.selectedHeart:
      return (
        <svg width={width} height={height} viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M18.3961 4.93277L18.3964 4.9331C18.7719 5.30843 19.0698 5.75406 19.273 6.24454C19.4763 6.73503 19.5809 7.26074 19.5809 7.79166C19.5809 8.32258 19.4763 8.8483 19.273 9.33878C19.0698 9.82926 18.7719 10.2749 18.3964 10.6502L18.3963 10.6504L17.4246 11.6221L11 18.0466L4.57547 11.6221L3.6038 10.6504C2.84562 9.89221 2.41968 8.86389 2.41968 7.79166C2.41968 6.71943 2.84562 5.69112 3.6038 4.93294C4.36198 4.17475 5.3903 3.74881 6.46253 3.74881C7.53476 3.74881 8.56307 4.17475 9.32125 4.93293L10.2929 5.9046C10.6834 6.29513 11.3166 6.29513 11.7071 5.9046L12.6788 4.93294L12.679 4.93277C13.0543 4.55726 13.4999 4.25939 13.9904 4.05616C14.4809 3.85293 15.0066 3.74832 15.5375 3.74832C16.0684 3.74832 16.5942 3.85293 17.0846 4.05616C17.5751 4.25939 18.0208 4.55726 18.3961 4.93277Z" fill={color} stroke="#FF6847" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      );

      case IconType.menu:
        return (
          <div className={classNames('icon', 'icon__menu', {
            'icon__menu--active': isActive,
          })}>
            <span className="icon__line" style={{ backgroundColor: color }} />
            <span className="icon__line" style={{ backgroundColor: color }} />
            <span className="icon__line" style={{ backgroundColor: color }} />
          </div>
        );

    default:
      return (
        <svg />
      );
  }
};
