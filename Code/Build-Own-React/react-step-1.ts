export type ReactElementProps = {[key: string]: string } & { children: ReactElement[]|string[] };

export type ReactElement = {
    type: string; // node name
    props: ReactElementProps;
};

export function createElement(type: string, config?: any, ...children: ReactElement[]|string[]):ReactElement{
    const props:any = {};

    if(config != null){
        for(let key in config){
            props[key] = config[key];
        }
    }

    if(children && children.length) props.children = children;

    return { type,props };
}

/**
 * 直接使用递归方式
 * 这种方式简单清晰，但是无法被中断，大量dom的情况下会造成浏览器卡顿
 */
export function render(element: ReactElement|string,container: HTMLElement){
    let node: any;
    if(typeof element === "string"){
        node = document.createTextNode(element);
    }else{
        node = document.createElement(element.type);
        (element.props.children || []).forEach(child => render(child,node));
    }
    container.appendChild(node);
}

